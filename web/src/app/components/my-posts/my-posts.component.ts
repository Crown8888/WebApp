import { Component } from '@angular/core';
import {DatePipe, NgForOf, SlicePipe} from "@angular/common";
import {IconsModule} from '../../icons/icons.module';
import {Router, RouterLink} from '@angular/router';
import {PostService} from '../../services/post.service';

@Component({
  selector: 'app-my-posts',
  imports: [
    NgForOf,
    SlicePipe,
    IconsModule,
    DatePipe,
    RouterLink,
  ],
  templateUrl: './my-posts.component.html',
  styleUrl: './my-posts.component.css'
})
export class MyPostsComponent {

  posts: any[] = [];

  constructor(private postService: PostService, private router: Router) {
    this.fetchPosts();
  }

  fetchPosts() {
    this.postService.getPostsForCurrentUser().subscribe((data: any) => {
      this.posts = data;
  });
  }

  readMore(id: number) {
    this.router.navigate(['/postView', id]);
  }
}
