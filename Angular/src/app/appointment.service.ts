import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  getData(): Observable<any> {
    return this.http.get<any>(`${this.url}/getallappointments`);
  }
  deleteData(appointment: Appointment): Observable<any> {
    return this.http.delete<any>(`${this.url}/delete-appointment/${appointment.appointmentId}`);
  }
  deleteAppointment(appointment: Appointment): Observable<any> {
    // tslint:disable-next-line: max-line-length
    return this.http.delete<any>(`${this.url}/delete-appointment/${appointment}`, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }
  updateData(appointment): Observable<any> {
    return this.http.put<any>(`${this.url}/modify-appointment`, appointment);
  }
}
