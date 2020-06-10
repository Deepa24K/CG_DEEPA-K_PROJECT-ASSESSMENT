import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CenterService } from '../center.service';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {
  message: any;
  error: any;


  constructor(private center: CenterService) { }

  ngOnInit() {
  }
  addCenter(form: NgForm) {
    this.center.addCenter(form.value).subscribe(res => {
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
