export class User {
  id: number;
  username: string;
  email: string;
  password: string;
  enabled: boolean;

  constructor(id: number, username: string, email: string, password: string, enabled: boolean) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.enabled = enabled;
  }

}
