import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: any;
  message: any;

  constructor(private auth: AdminService,
              private router: Router) { }

  ngOnInit() {
  }
  login(form: NgForm) {
    this.auth.login(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.discription;
        setTimeout(() => {
          this.message = null;
        }, 5000);
        form.reset();
        console.log(res);
        localStorage.setItem('userDetails.beans', JSON.stringify(res));
        console.log('user details stored in local storage');
        const userDetails = JSON.parse(localStorage.getItem('userDetails.beans'));
        if (userDetails && userDetails.beans[0].role === 'admin') {
          console.log(userDetails.beans[0].role);
          this.router.navigateByUrl('/adminhome');
        }
       } else {
          this.error = res.discription;
          setTimeout(() => {
            this.error = null;
          }, 5000);
          form.reset();
        }
    });
  }
}
