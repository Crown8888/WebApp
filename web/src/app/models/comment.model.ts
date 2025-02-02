import {User} from './user';
import {Post} from './post.model';

export class Comment {

  id: number;
  content: string;
  created_at?: string;
  user?: User;
  post?: Post;

  constructor(id: number, content: string, created_at?: string, user?: User, post?: Post) {
    this.id = id;
    this.content = content;
    this.created_at = created_at;
    this.user = user;
    this.post = post;
  }


}
