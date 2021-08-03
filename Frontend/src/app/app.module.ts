import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component'
import { SignupComponent } from './auth/signup/signup.component';
import { SidebarComponent } from './admin/templates/sidebar/sidebar.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { AgencyComponent } from './admin/agency/agency.component';
import { BusesComponent } from './admin/buses/buses.component';
import { TripsComponent } from './admin/trips/trips.component';
import { ProfileComponent } from './admin/profile/profile.component';
import { TemplatesComponent } from './admin/templates/templates.component';
import { FooterComponent } from './admin/templates/footer/footer.component';
import { NavigationComponent } from './admin/templates/navigation/navigation.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    SidebarComponent,
    DashboardComponent,
    AgencyComponent,
    BusesComponent,
    TripsComponent,
    ProfileComponent,
    TemplatesComponent,
    FooterComponent,
    NavigationComponent
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
