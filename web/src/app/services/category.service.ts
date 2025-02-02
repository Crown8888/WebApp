import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../app.config';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly APIUrlCategory: string;
  constructor(private http: HttpClient) {
    this.APIUrlCategory = environment.apiUrl + '/categories';
  }

  getAllCategories() {
    return this.http.get(this.APIUrlCategory);
  }
}
