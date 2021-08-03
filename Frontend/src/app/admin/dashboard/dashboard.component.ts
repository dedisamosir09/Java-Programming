import { Component, OnInit } from '@angular/core';
import { UserService } from "../../api_services/user.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public content?: any;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserData().subscribe(
      data => {
        this.content = data;
      }
    )
  }
}
