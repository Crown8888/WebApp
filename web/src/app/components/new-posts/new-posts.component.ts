import { Component } from '@angular/core';
import {CommonModule, SlicePipe} from '@angular/common';

@Component({
  selector: 'app-new-posts',
  imports: [
    SlicePipe,
    CommonModule
  ],
  templateUrl: './new-posts.component.html',
  styleUrl: './new-posts.component.css'
})
export class NewPostsComponent {
  posts = [
    { id: 1, title: 'Wprowadzenie do Termodynamiki', summary: 'Podstawowy przewodnik po zasadach termodynamiki.', createdAt: '2025-01-01 15:00', user:{ username: 'admin'} },
    { id: 2, title: 'Najnowsze trendy w inżynierii mechanicznej', summary: 'Odkryj najnowsze osiągnięcia w tej dziedzinie.', createdAt: '2025-01-02 15:00',user:{ username: 'admin'}  }
  ];
  readMore(id: number) {
    console.log('Przechodzenie do artykułu', id);
  }

}
