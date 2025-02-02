import {Component, OnInit} from '@angular/core';
import  {CommonModule} from '@angular/common';
import {User} from '../../models/user';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [CommonModule]
})
export class HomeComponent implements OnInit {
  user: User;
  detailsLoaded: boolean = false;
  posts = [
    { id: 1, title: 'Wprowadzenie do Termodynamiki', summary: 'Podstawowy przewodnik po zasadach termodynamiki.' },
    { id: 2, title: 'Najnowsze trendy w inżynierii mechanicznej', summary: 'Odkryj najnowsze osiągnięcia w tej dziedzinie.' }
  ];

  constructor(private userService: UserService) {
    this.user = new User(
      1,
      'Jan',
      'temp@temp.pl',
      'temp',
      false,
    );
  }

  ngOnInit(): void {
    this.userService.getCurrentUser().subscribe(
      (response: any) => {
        this.user = response;
        this.detailsLoaded = true;
      }
    );
  }
  readMore(id: number) {
    console.log('Przechodzenie do artykułu', id);
  }

  logout() {
    this.userService.logout();
  }
}
