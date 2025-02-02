import {Post} from './post.model';
import {User} from './user';

export class Like {

  id: number;
  created_at: string;
  post?: Post;
  user?: User;

  constructor(id: number, created_at: string, post?: Post, user?: User) {
    this.id = id;
    this.created_at = created_at;
    this.post = post;
    this.user = user;
  }

}
