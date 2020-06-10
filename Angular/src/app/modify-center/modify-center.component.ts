import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-center',
  templateUrl: './modify-center.component.html',
  styleUrls: ['./modify-center.component.css']
})
export class ModifyCenterComponent implements OnInit {
  centerIdUpdate: any;
  centerNameUpdate: any;

  constructor(private centerDel: CenterService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe(res => {
      console.log(res.centerId);
      this.centerIdUpdate = res.centerId;
    });
    activatedRoute.queryParams.subscribe(res => {
      console.log(res);
      this.centerNameUpdate = res.centerName;
    });
  }

  ngOnInit() {
  }
  updateCenter(form: NgForm) {
    this.centerDel.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.router.navigateByUrl('/getall-centers');
        form.reset();
      }
    });
  }

}
