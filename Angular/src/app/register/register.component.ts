import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  message: any;
  error: any;

  constructor(private auth: AdminService) { }

  ngOnInit() {
  }
  register(form: NgForm) {
    this.auth.register(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.discription;
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 5000);
      } else {
        form.reset();
        this.error = res.discription;
        setTimeout(() => {
          this.message = null;
        }, 5000);
      }
    }, err => {
      console.log(err);
      this.error = err.discription;
      form.reset();
      setTimeout(() => {
        this.error = null;
      }, 5000);
    }
    );
  }
}
