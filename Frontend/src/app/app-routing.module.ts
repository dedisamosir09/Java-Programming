import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { AgencyComponent } from './admin/agency/agency.component';
import { BusesComponent } from './admin/buses/buses.component';
import { TripsComponent } from './admin/trips/trips.component';
import { ProfileComponent } from './admin/profile/profile.component';
import { TemplatesComponent } from './admin/templates/templates.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  {
    path: 'admin', component: TemplatesComponent,
    children: [
      {
        path: "dashboard",
        component: DashboardComponent
      },
      {
        path: "agency",
        component: AgencyComponent
      },
      {
        path: "buses",
        component: BusesComponent
      },
      {
        path: "trips",
        component: TripsComponent
      },
      {
        path: "profile",
        component: ProfileComponent
      },
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  }, { path: '', redirectTo: 'admin', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
