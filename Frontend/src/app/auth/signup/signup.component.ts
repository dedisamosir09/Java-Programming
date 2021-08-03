import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../api_services/auth.service';
import { TokenStorageService } from '../../api_services/token-storage.service';
import { Router } from "@angular/router"

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';


  constructor(private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, password, firstName, lastName, agency, details, mobileNumber } = this.form;

    this.authService.register(username, firstName, lastName, mobileNumber, ['admin'], password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.registerAgency(agency, details);
        this.router.navigate(['login']);
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  registerAgency(name: string, details: string): void {
    this.authService.registerAgency(name, details, "A-" + name).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigate(['login']);
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
