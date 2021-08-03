import { Component, OnInit } from '@angular/core';
import { AgencyService } from "../../api_services/agency.service";

@Component({
  selector: 'app-agency',
  templateUrl: './agency.component.html',
  styleUrls: ['./agency.component.css']
})
export class AgencyComponent implements OnInit {
  content?: any;
  public _editModel?: any;

  constructor(private agencyService: AgencyService) { }

  ngOnInit(): void {
    this.agencyService.getAll().subscribe(
      data => {
        this.content = data;
        this._editModel = Object.assign({}, data);
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    )
  }

  public submitEdit(): void {
    this._editModel.code = this.content.code;

    this.agencyService.updateAgency(
      {
        'code': this._editModel.code,
        'details': this._editModel.details,
        'name': this._editModel.name
      }).subscribe(
        data => {
          this.content = data;
          this._editModel = data;
          this.reloadPage();
        },
        err => {
          this.content = JSON.parse(err.error).message;
        }
      )
  }

  reloadPage(): void {
    window.location.reload();
  }

}
