import { Component } from '@angular/core';
import { CommonModule, SlicePipe } from '@angular/common';
import { Router } from '@angular/router';
import { PostService } from '../../services/post.service';
import { Post } from '../../models/post.model';

@Component({
  selector: 'app-new-posts',
  imports: [ CommonModule],
  templateUrl: './new-posts.component.html',
  styleUrl: './new-posts.component.css',
})
export class NewPostsComponent {
  posts: Post[] = [];

  constructor(private router: Router, private postService: PostService) {
    this.fetchPosts();
  }

  fetchPosts() {
    this.postService.getNewPosts().subscribe((data: any) => {
      this.posts = data as Post[];
      this.posts = data;
    });
  }

  readMore(id: number) {
    this.router.navigate(['/postView', id]);
  }
}
