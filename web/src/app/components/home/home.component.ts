import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  token: string | null = '';

  ngOnInit(): void {
    this.token = sessionStorage.getItem('token');
  }

}
