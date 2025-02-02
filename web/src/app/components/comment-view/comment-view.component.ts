import { Component } from '@angular/core';

@Component({
  selector: 'app-comment-view',
  imports: [],
  templateUrl: './comment-view.component.html',
  styleUrl: './comment-view.component.css'
})
export class CommentViewComponent {

  comment = { content: 'Komentarz', user: { username: 'admin' }, createdAt: '2025-01-01 15:00', likes: 0 };

  likeComment(){
    console.log('Polubienie zostało dodane.');
  }

}
