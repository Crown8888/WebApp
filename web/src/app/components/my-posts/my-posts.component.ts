import { Component } from '@angular/core';
import {DatePipe, NgForOf, SlicePipe} from "@angular/common";
import {IconsModule} from '../../icons/icons.module';
import {RouterLink} from '@angular/router';

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
  posts = [
    { id: 1, title: 'Wprowadzenie do Termodynamiki', summary: 'Podstawowy przewodnik po zasadach termodynamiki.', createdAt: '2025-01-01 15:00', user:{ username: 'admin'} },
    { id: 2, title: 'Najnowsze trendy w inżynierii mechanicznej', summary: 'Odkryj najnowsze osiągnięcia w tej dziedzinie.', createdAt: '2025-01-02 15:00',user:{ username: 'admin'}  }
  ];
  readMore(id: number) {
    console.log('Przechodzenie do artykułu', id);
  }
}
