import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modify-test',
  templateUrl: './modify-test.component.html',
  styleUrls: ['./modify-test.component.css']
})
export class ModifyTestComponent implements OnInit {
  testIdUpdate;
  centerIdUpdate;
  testNameUpdate;

  constructor(private testDel: TestService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
                activatedRoute.params.subscribe(res => {
                  console.log(res.testId);
                  this.testIdUpdate = res.testId;
                });
                activatedRoute.queryParams.subscribe(res => {
                  console.log(res);
                  this.testNameUpdate = res.testName;
                  this.centerIdUpdate = res.centerId;
                });
              }

  ngOnInit() {
  }
  updateTest(form: NgForm) {
    this.testDel.updateInfo(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.router.navigateByUrl('/getall-tests');
        form.reset();
      }
    });
  }

}
