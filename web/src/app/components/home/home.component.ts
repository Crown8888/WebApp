import {Component, OnInit} from '@angular/core';
import  {CommonModule} from '@angular/common';
import {User} from '../../models/user';
import {UserService} from '../../services/user.service';
import {MatDialog} from '@angular/material/dialog';
import {PostCreatorComponent} from '../post-creator/post-creator.component';
import {RouterLink, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  imports: [CommonModule, RouterOutlet, RouterLink]
})
export class HomeComponent implements OnInit {
  user: User;
  detailsLoaded: boolean = false;


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


  logout() {
    this.userService.logout();
  }
}
