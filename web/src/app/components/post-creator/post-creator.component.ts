import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-post-creator',
  imports: [
    ReactiveFormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './post-creator.component.html',
  styleUrl: './post-creator.component.css'
})
export class PostCreatorComponent implements OnInit {
  newPostForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.newPostForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(5)]],
      content: ['', [Validators.required, Validators.minLength(10)]],
      category: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  ngOnInit() {

  }

  addPost() {
    if (this.newPostForm.valid) {
      console.log('New post added:', this.newPostForm.value);
      this.newPostForm.reset();
    } else {
      console.log('Form is invalid');
    }
  }
}
