import { Injectable } from '@angular/core';
import { environment } from '../app.config'
import {HttpClient} from '@angular/common/http';
import {of, tap} from 'rxjs';
import {AuthService} from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class UserService{

  private currentUser: any;
  private APIUrlUser: string;
  constructor(private http:HttpClient, private authService: AuthService) {
    this.APIUrlUser = environment.apiUrl + '/user';
  }

  getCurrentUser(): any {
    return this.currentUser
      ? of(this.currentUser)
      : this.http.get(`${(this.APIUrlUser)}/current`).pipe(
        tap(data => { this.currentUser = data }),
      )
  }
  logout(): void {
    this.removeCurrentUser();
    this.authService.logout();
  }

  removeCurrentUser(): void {
    this.currentUser = null;
  }
}
