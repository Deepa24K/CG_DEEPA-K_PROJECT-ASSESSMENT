import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {
  message: any;
  error: any;
  constructor(private test: TestService) { }

  ngOnInit() {
  }
  addTest(form: NgForm) {
    this.test.addTest(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.discription;
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
      } else {
        this.error = res.discription;
        setTimeout(() => {
          this.error = null;
        }, 2000);
      }
    });
  }
}
