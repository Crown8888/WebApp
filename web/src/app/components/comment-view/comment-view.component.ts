import { Component, Input } from '@angular/core';
import { Comment } from '../../models/comment.model';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-comment-view',
  templateUrl: './comment-view.component.html',
  imports: [
    DatePipe
  ],
  styleUrl: './comment-view.component.css'
})
export class CommentViewComponent {
  @Input() comment!: Comment;

  constructor() {}

  likeComment() {
    console.log('Polubienie zostało dodane.');
  }
}
