import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-centers',
  templateUrl: './getall-centers.component.html',
  styleUrls: ['./getall-centers.component.css']
})
export class GetallCentersComponent implements OnInit {

  success: string;
  failure: string;
  centers: Center[];

  constructor(private centerDel: CenterService,
              private router: Router) {
                this.showAllCenters();
               }
  deleteCenter(center: Center) {
    this.centerDel.deleteCenter(center).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.centers.splice(this.centers.indexOf(center), 1);
        this.success = res.success;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    });
  }
  showAllCenters() {
    this.centerDel.showAllCenters().subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.centers = res.beans;
        this.success = res.discription;
        localStorage.setItem('centers Details', JSON.stringify(res));
        console.log('Center Details are added');
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    });
  }
  updateCenter(center) {
    this.router.navigate([`modify-center/${center.centerId}`],
    {queryParams: {centerName: center.centerName}
    }
    );
  }
  ngOnInit() {
  }
}
