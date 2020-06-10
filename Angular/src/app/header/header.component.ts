import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans'));
    if (userDetails && userDetails.beans[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  logout() {
    localStorage.removeItem('userDetails.beans');
    this.router.navigateByUrl('/login');
  }
}
