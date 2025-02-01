import {inject, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { environment } from '../app.config';
import { User } from '../models/user';
import {ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot} from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

interface LoginResponse {
  token: string;
  userEntity: User;
}



@Injectable({ providedIn: 'root' })
export class AuthService {
  private loggedIn = new BehaviorSubject<boolean>(false);
  private user: User | null;
  private token: string | null;

  constructor(private http: HttpClient, private router: Router, private jwtHelper: JwtHelperService) {
    this.user = null;
    this.token = '';
  }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (sessionStorage.getItem('token') && !this.jwtHelper.isTokenExpired(tokenGetter())) {
      return true;
    }
    return false;
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  loadToken() {
    this.token = sessionStorage.getItem('token') || '';
    if (this.token) {
      this.loggedIn.next(true);
    }
  }

  login(user: User) {
    this.user = user;
    let url = environment.apiUrl + '/login';
    this.http.post<LoginResponse>(url, {
      username: this.user.username,
      password: this.user.password
    }).subscribe(
      response => {
        if (response && response.token) {
          this.token = response.token;
          sessionStorage.setItem('token', this.token);
          this.user = response.userEntity;
          this.loggedIn.next(true);
          this.router.navigate(['/home']);
        }
      },
    );
  }

  logout() {
    this.loggedIn.next(false);
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

}

export const AuthGuard: CanActivateFn = async (next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> => {
  const authService = inject(AuthService);
  const canActivate = authService.canActivate(next, state);
 // const checkRole = await authService.checkRole(next);
  return canActivate;
}

export function tokenGetter() {
  return sessionStorage.getItem("token");
}
