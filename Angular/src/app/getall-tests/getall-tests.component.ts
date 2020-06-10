import { Component, OnInit } from '@angular/core';
import { TestService } from '../test.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-getall-tests',
  templateUrl: './getall-tests.component.html',
  styleUrls: ['./getall-tests.component.css']
})
export class GetallTestsComponent implements OnInit {
  success: string;
  failure: string;
  tests: Test[];

  constructor(private testDel: TestService,
              private router: Router) {
                this.showAllTests();
              }
              deleteTest(test: Test) {
                this.testDel.deleteTest(test).subscribe(res => {
                  console.log(res);
                  if (res.statusCode === 201) {
                    this.tests.splice(this.tests.indexOf(test), 1);
                    this.success = res.success;
                    setTimeout(() => {
                      this.success = null;
                    }, 2000);
                  }
                });
              }
              showAllTests() {
                this.testDel.showAllTests().subscribe(res => {
                  console.log(res);
                  if (res.statusCode === 201) {
                    this.tests = res.beans;
                    this.success = res.discription;
                    localStorage.setItem('tests Details', JSON.stringify(res));
                    console.log('Test Details are added');
                    setTimeout(() => {
                      this.success = null;
                    }, 2000);
                  }
                });
              }
              updateTest(test) {
                this.router.navigate([`modify-test/${test.testId}`],
                {queryParams: {testName: test.testName, centerId: test.centerId}
                }
                );
              }

  ngOnInit() {
  }

}
