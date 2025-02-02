import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {AuthGuard} from './services/auth.service';
import {PostCreatorComponent} from './components/post-creator/post-creator.component';
import {NewPostsComponent} from './components/new-posts/new-posts.component';
import {AllPostsComponent} from './components/all-posts/all-posts.component';
import {MyPostsComponent} from './components/my-posts/my-posts.component';
import {AboutComponent} from './components/about/about.component';
import {ContactComponent} from './components/contact/contact.component';
import {PostViewComponent} from './components/post-view/post-view.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '', redirectTo: 'newPosts', pathMatch: 'full' },
      { path: 'newPosts', component: NewPostsComponent},
      { path: 'postCreator', component: PostCreatorComponent },
      { path: 'allPosts', component: AllPostsComponent },
      { path: 'myPosts', component: MyPostsComponent },
      { path: 'about', component: AboutComponent},
      { path: 'contact', component: ContactComponent },
      { path: 'postView/:id', component: PostViewComponent }
      ]
  },
  { path: 'login', component: LoginComponent },
];
