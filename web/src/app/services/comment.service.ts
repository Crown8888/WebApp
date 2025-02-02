import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../app.config';
import {Comment} from '../models/comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private readonly APIUrlComment: string;
  constructor(private http: HttpClient) {
    this.APIUrlComment = environment.apiUrl + '/comments';
  }

  getCommentsByPostId(postId: number) {
    return this.http.get(`${this.APIUrlComment}/post/${postId}`);
  }

  addComment(comment: any) {
    return this.http.post(this.APIUrlComment, comment);
  }

}
