export class Post {
  id: number;
  title?: string;
  content?: string;
  created_at?: string;
  user: {
    username: string;
    id?: number;
  };

  constructor(
    id: number,
    title: string,
    content: string,
    created_at: string,
    user: { username: string; id?: number },
  ) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.created_at = created_at;
    this.user = user;
  }
}
