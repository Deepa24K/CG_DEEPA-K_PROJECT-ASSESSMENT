import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AddCenterComponent } from './add-center/add-center.component';
import { GetallCentersComponent } from './getall-centers/getall-centers.component';
import { AddTestComponent } from './add-test/add-test.component';
import { GetallTestsComponent } from './getall-tests/getall-tests.component';
import { ModifyCenterComponent } from './modify-center/modify-center.component';
import { ConfirmappointmentComponent } from './confirmappointment/confirmappointment.component';
import { ModifyTestComponent } from './modify-test/modify-test.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { GetallappointmentsComponent } from './getallappointments/getallappointments.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    AdminhomeComponent,
    AddCenterComponent,
    GetallCentersComponent,
    AddTestComponent,
    GetallTestsComponent,
    ModifyCenterComponent,
    
    ConfirmappointmentComponent,
    
    ModifyTestComponent,
    
    PagenotfoundComponent,
    
    GetallappointmentsComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
