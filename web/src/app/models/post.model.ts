export class Post {
  id: number;
  title: string;
  summary: string;
  createdAt: string;
  user: {
    username: string;
    id?: number;
  };
  userId?: number;
  constructor(
    id: number,
    title: string,
    summary: string,
    createdAt: string,
    user: { username: string; id?: number },
    userId?: number
  ) {
    this.id = id;
    this.title = title;
    this.summary = summary;
    this.createdAt = createdAt;
    this.user = user;
    this.userId = userId;
  }
}
