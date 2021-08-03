import { Component, OnInit } from '@angular/core';
import { UserService } from "../../api_services/user.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public content?: any;
  public updtData: any = {};
  public updtPassword: any = {};
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserData().subscribe(
      data => {
        this.content = data;
        this.updtData.firstName = data.firstName;
        this.updtData.lastName = data.lastName;
        this.updtData.mobileNumber = data.mobileNumber;
        this.updtPassword.username = data.username;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    )
  }

  public submitData(): void {
    this.userService.updateData(this.updtData).subscribe(
      data => {
        this.content = data;
        this.reloadPage();
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    )
  }


  public updatePassword(): void {
    if (this.validatePassword()) {
      this.userService.updatePassword(this.updtPassword).subscribe(
        data => {
          this.content = data;
          this.reloadPage();
        },
        err => {
          this.content = JSON.parse(err.error).message;
        }
      )
    }
  }

  reloadPage(): void {
    window.location.reload();
  }

  public validatePassword(): boolean {
    let status: boolean = true;
    if (typeof (this.updtPassword.password) === "undefined") {
      alert("password is balank");
      status = false;
      return false;
    }
    return status;
  }


}
