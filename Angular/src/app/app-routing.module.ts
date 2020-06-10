import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { GetallCentersComponent } from './getall-centers/getall-centers.component';
import { AddTestComponent } from './add-test/add-test.component';
import { GetallTestsComponent } from './getall-tests/getall-tests.component';
import { ModifyCenterComponent } from './modify-center/modify-center.component';
import { ModifyTestComponent } from './modify-test/modify-test.component';
import { RegisterComponent } from './register/register.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { GetallappointmentsComponent } from './getallappointments/getallappointments.component';
import { ConfirmappointmentComponent } from './confirmappointment/confirmappointment.component';



const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'about', component: AboutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'adminhome', component: AdminhomeComponent},
  {path: 'add-center', component: AddCenterComponent},
  {path: 'getall-centers', component: GetallCentersComponent},
  {path: 'modify-center/:centerId', component: ModifyCenterComponent},
  {path: 'add-test', component: AddTestComponent},
  {path: 'getall-tests', component: GetallTestsComponent},
  {path: 'modify-test/:testId', component: ModifyTestComponent},
  {path: 'getallappointments', component: GetallappointmentsComponent},
  {path: 'confirmappointment/:appointmentId', component: ConfirmappointmentComponent},
  {path: '**', component: PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
