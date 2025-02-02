import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {SlicePipe} from '@angular/common';
import {CommonModule} from '@angular/common';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-post-creator',
  imports: [
    FormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './post-creator.component.html',
  styleUrl: './post-creator.component.css'
})
export class PostCreatorComponent {

  newPost = { title: '', content: '', category: '' };
  posts = [
    { title: 'Wprowadzenie do Termodynamiki', content: 'Podstawowy przewodnik po zasadach termodynamiki.', category: 'Termodynamika' },
    { title: 'Najnowsze trendy w inżynierii mechanicznej', content: 'Odkryj najnowsze osiągnięcia w tej dziedzinie.', category: 'Inżynieria mechaniczna' }
    ];
  constructor() { }
  addPost() {
    this.newPost = { title: '', content: '', category: '' };
  }

}
