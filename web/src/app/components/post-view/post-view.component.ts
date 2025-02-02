import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CommentViewComponent } from '../comment-view/comment-view.component';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-post-view',
  imports: [
    ReactiveFormsModule,
    CommentViewComponent,
    NgForOf,
    NgIf
  ],
  templateUrl: './post-view.component.html',
  styleUrl: './post-view.component.css'
})
export class PostViewComponent implements OnInit {
  post = { title: 'Wprowadzenie do Termodynamiki', content: 'Podstawowy przewodnik po zasadach termodynamiki.',
    category: 'Termodynamika', user: { username: 'admin' },
    likes: 0, comments: [{id: 1}, {id: 2}], createdAt: '2025-01-01 15:00' };
  commentForm: FormGroup;

  constructor(private route: ActivatedRoute, private fb: FormBuilder) {
    this.commentForm = this.fb.group({
      content: ['', [Validators.required, Validators.minLength(5)]]
    });
  }

  ngOnInit() {
    const postId = this.route.snapshot.paramMap.get('id');
    console.log('Post ID:', postId);


  }

  addComment() {
    if (this.commentForm.valid) {
      console.log('Komentarz został dodany. ' + this.commentForm.value.content);
      this.commentForm.reset();
    } else {
      console.log('Formularz jest nieprawidłowy.');
    }
  }

  addLike() {
    console.log('Polubienie zostało dodane.');
  }
}
