import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../app.config';

@Injectable({
  providedIn: 'root'
})
export class LikeService {

  private readonly APIUrlLike: string;
  constructor(private http: HttpClient) {
    this.APIUrlLike = environment.apiUrl + '/likes';
  }

  getLikesByPostId(postId: number) {
    return this.http.get(`${this.APIUrlLike}/post/${postId}`);
  }

  addLike(postId: number) {
    return this.http.get(`${this.APIUrlLike}/post/${postId}`);
  }

}
