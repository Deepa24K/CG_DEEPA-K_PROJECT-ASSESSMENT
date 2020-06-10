import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  api = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  login(userDetails): Observable<any> {
    return this.http.post<any>(`${this.api}/login`, userDetails );
  }
  register(userDetails): Observable<any> {
    return this.http.post<any>(`${this.api}/register`, userDetails );
  }
}
