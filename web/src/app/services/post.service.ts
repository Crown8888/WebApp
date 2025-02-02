import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../app.config';
@Injectable({
  providedIn: 'root',
})
export class PostService {
  private readonly APIUrlPost: string;
  constructor(private http: HttpClient) {
    this.APIUrlPost = environment.apiUrl + '/posts';
  }
  getAllPosts() {
    return this.http.get(this.APIUrlPost);
  }
  getPostsForCurrentUser() {
    return this.http.get(`${this.APIUrlPost}/current`);
  }
  getPostById(id: number) {
    return this.http.get(`${this.APIUrlPost}/${id}`);
  }
  createPost(post: any) {
    return this.http.post(this.APIUrlPost, post);
  }
  getNewPosts() {
    return this.http.get(`${this.APIUrlPost}/new`);
  }
}
