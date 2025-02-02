import {Component, OnInit} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {CommentViewComponent} from '../comment-view/comment-view.component';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-post-view',
  imports: [
    FormsModule,
    CommentViewComponent,
    NgForOf
  ],
  templateUrl: './post-view.component.html',
  styleUrl: './post-view.component.css'
})
export class PostViewComponent implements OnInit {


  post = { title: 'Wprowadzenie do Termodynamiki', content: 'Podstawowy przewodnik po zasadach termodynamiki.',
    category: 'Termodynamika', user: { username: 'admin' },
    likes: 0, comments: [{id: 1},
      {id: 2}], createdAt: '2025-01-01 15:00' };
 newComment = { content: '' };

 constructor(private route: ActivatedRoute) { }
  ngOnInit() {
    const postId = this.route.snapshot.paramMap.get('id');
    // Fetch the post using the postId
    console.log('Post ID:', postId);
  }
  addComment(){
    console.log('Komentarz został dodany. ' + this.newComment.content);
    this.newComment = { content: '' };
  }

  addLike(){
    console.log('Polubienie zostało dodane.');
  }
}
