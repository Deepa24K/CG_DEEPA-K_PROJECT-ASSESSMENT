import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getallappointments',
  templateUrl: './getallappointments.component.html',
  styleUrls: ['./getallappointments.component.css']
})
export class GetallappointmentsComponent implements OnInit {
  discription: string;
  appointments: Appointment[];

  constructor(private appointmentService: AppointmentService, private router: Router) {
    this.getAllAppointments();
  }
  getAllAppointments() {
    this.appointmentService.getData().subscribe(res => {
      console.log(res);
      this.appointments = res.beans;
      console.log(this.appointments[0].appointmentId);
    }, err => {
      console.log(err);
    });
  }
  deleteAppointment(appointment: Appointment) {
   this.appointmentService.deleteData(appointment).subscribe(res => {
     console.log(res);
     if (res.statusCode === 201) {
       this.appointments.splice(this.appointments.indexOf(appointment), 1);
       this.discription = res.discription;
     }
   });
 }
 deleteMessage() {
   this.discription = null;
 }
 confirmappointment(appointment: Appointment) {
   console.log(appointment);
   console.log(appointment.status);
   this.router.navigate([`confirmappointment/${appointment.appointmentId}`],
   {queryParams: {userId: appointment.userId, userName: appointment.userName,
     testId: appointment.testId , testName: appointment.testName,
     centerId: appointment.centerId, centerName: appointment.centerName,
    appointmentDate: appointment.appointmentDate, appointmentTime: appointment.appointmentTime}
   }
   );
 }


  ngOnInit() {
  }

}
