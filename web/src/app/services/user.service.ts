import { Injectable } from '@angular/core';
import { environment } from '../app.config'
import {HttpClient} from '@angular/common/http';
import {of, tap} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService{

  private currentUser: any;
  private APIUrlUser: string;
  constructor(private http:HttpClient) {
    this.APIUrlUser = environment.apiUrl + '/user';
  }

  getCurrentUser(): any {
    return this.currentUser
      ? of(this.currentUser)
      : this.http.get(`${(this.APIUrlUser)}/current`).pipe(
        tap(data => { this.currentUser = data }),
      )
  }

  removeCurrentUser(): void {
    this.currentUser = null;
  }
}
