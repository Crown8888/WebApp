import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CommentViewComponent } from '../comment-view/comment-view.component';
import {DatePipe, NgForOf, NgIf} from '@angular/common';
import {PostService} from '../../services/post.service';
import {Post} from '../../models/post.model';
import {Comment} from '../../models/comment.model';
import {CommentService} from '../../services/comment.service';
import {LikeService} from '../../services/like.service';

@Component({
  selector: 'app-post-view',
  imports: [
    ReactiveFormsModule,
    CommentViewComponent,
    NgForOf,
    NgIf,
    DatePipe
  ],
  templateUrl: './post-view.component.html',
  styleUrl: './post-view.component.css'
})
export class PostViewComponent implements OnInit {
  post : any;
  commentForm: FormGroup;
  postLoaded: boolean = false;
  commentsLoaded: boolean = false;
  likesLoaded: boolean = false;
  likes: number = 0;
  comments: Comment[] = [];

  constructor(private route: ActivatedRoute, private fb: FormBuilder, private postService: PostService,
              private commentService: CommentService, private likeService: LikeService) {
    this.commentForm = this.fb.group({
      content: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  fetchPost(postId: number) {
    this.postService.getPostById(postId).subscribe((post) => {
      this.post = post;
      this.postLoaded = true;
    });
  }

  fetchComments(postId: number) {
    this.commentService.getCommentsByPostId(postId).subscribe((comments:any) => {
      this.comments = comments;
      this.commentsLoaded = true;
    });
  }

  fetchLikes(postId: number) {
    this.likeService.getLikesByPostId(postId).subscribe((likes:any) => {
      this.likes = Number(likes);
      this.likesLoaded = true;
    });
  }

  ngOnInit() {
    const postId = this.route.snapshot.paramMap.get('id');
    console.log('Post ID:', postId);
    if(postId) {
      this.fetchPost(Number(postId));
      this.fetchComments(Number(postId));
      this.fetchLikes(Number(postId));
    }
  }

  addComment() {
    if (this.commentForm.valid) {
      console.log('Komentarz został dodany. ' + this.commentForm.value.content);
      this.commentService.addComment({
        content: this.commentForm.value.content,
        post: {
          id: this.post.id
        }
      }).subscribe((response) => {
        console.log('Komentarz został dodany.');
      });
      this.commentForm.reset();
    } else {
      console.log('Formularz jest nieprawidłowy.');
    }
  }

  addLike() {
    this.likeService.addLike(this.post.id).subscribe((response) => {
      console.log('Like added:', response);
      this.likes++;
    });
  }
}
