import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  addCenter(centerDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/add-center`, centerDetails);
  }
  showAllCenters(): Observable<any> {
    return this.http.get<any>(`${this.url}/getall-centers`);
  }
  deleteCenter(center: Center): Observable<any> {
    return this.http.delete<any>(`${this.url}/remove-center/${center.centerId}`);
  }
  updateData(center): Observable<any> {
    return this.http.put<any>(`${this.url}/modify-center`, center);
  }
}
