import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import {PostService} from '../../services/post.service';
import {CategoryService} from '../../services/category.service';

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
  categories: any;
  dataLoaded: boolean = false;

  constructor(private fb: FormBuilder, private postService: PostService, private categoryService: CategoryService) {
    this.newPostForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(5)]],
      content: ['', [Validators.required, Validators.minLength(10)]],
      category: ['', [Validators.required]],
    });
  }

  fetchCategories() {
    this.categoryService.getAllCategories().subscribe((categories) => {
      this.categories = categories;
      this.dataLoaded = true;
    });
  }

  ngOnInit() {
    this.fetchCategories();
  }

  addPost() {
    if (this.newPostForm.valid) {
      console.log('New post added:', this.newPostForm.value);
      this.postService.createPost(this.newPostForm.value).subscribe((response) => {
        console.log('Post added:', response);
      });
      this.newPostForm.reset();
    } else {
      console.log('Form is invalid');
    }
  }
}
