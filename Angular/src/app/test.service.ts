import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestService {
  url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  addTest(testDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-test`, testDetails);
  }
  showAllTests(): Observable<any> {
    return this.http.get<any>(`${this.url}/getall-tests`);
  }
  deleteTest(test: Test): Observable<any> {
    return this.http.delete<any>(`${this.url}/remove-test/${test.centerId}`);
  }
  updateInfo(test): Observable<any> {
    return this.http.put<any>(`${this.url}/modify-test`, test);
  }
}
