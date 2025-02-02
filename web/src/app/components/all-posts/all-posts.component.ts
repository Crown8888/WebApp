import { Component } from '@angular/core';
import {DatePipe, NgForOf} from "@angular/common";
import {Post} from '../../models/post.model';
import {Router} from '@angular/router';
import {PostService} from '../../services/post.service';

@Component({
  selector: 'app-all-posts',
    imports: [
        DatePipe,
        NgForOf
    ],
  templateUrl: './all-posts.component.html',
  styleUrl: './all-posts.component.css'
})
export class AllPostsComponent {
  posts: Post[] = [];

  constructor(private router: Router, private postService: PostService) {
    this.fetchPosts();
  }

  fetchPosts() {
    this.postService.getAllPosts().subscribe((data: any) => {
      this.posts = data as Post[];
      this.posts = data;
    });
  }

  readMore(id: number) {
    this.router.navigate(['/postView', id]);
  }
}
