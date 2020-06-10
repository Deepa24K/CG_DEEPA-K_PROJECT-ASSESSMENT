import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-confirmappointment',
  templateUrl: './confirmappointment.component.html',
  styleUrls: ['./confirmappointment.component.css']
})
export class ConfirmappointmentComponent implements OnInit {
  appointmentIdUpdate: any;
  statusUpdate: any;
  appointmentTimeUpdate: any;
  appointmentDateUpdate: any;

  constructor(private appointmentService: AppointmentService,
              private router: Router, private activatedRoute: ActivatedRoute) {
                activatedRoute.params.subscribe(res => {
                  console.log(res);
                  console.log(res.appointmentId);
                  this.appointmentIdUpdate = res.appointmentId;
                });
                activatedRoute.queryParams.subscribe(res => {
                  console.log(res);
                  this.appointmentTimeUpdate = res.appointmentTime;
                  this.appointmentDateUpdate = res.appointmentDate;
                  this.statusUpdate = res.status;
                });
               }

  ngOnInit() {
  }
  addTime(time: string) {
    this.appointmentTimeUpdate = time;
  }

  confirmappointment(form: NgForm) {
    this.appointmentService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.router.navigateByUrl('/getallappointments');
        form.reset();
      }
    });
  }

}
