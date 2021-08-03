import { Component, OnInit } from '@angular/core';
import { BusesService } from "../../api_services/buses.service";


@Component({
  selector: 'app-buses',
  templateUrl: './buses.component.html',
  styleUrls: ['./buses.component.css']
})
export class BusesComponent implements OnInit {
  content?: Array<any>;
  public buses: any = {};

  constructor(private busesService: BusesService) {

  }

  ngOnInit(): void {
    this.busesService.getAll().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    )
  }

  public submit(): void {
    this.busesService.createBus(this.buses).subscribe(
      data => {
        this.reloadPage();
      },
      err => {
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }


}
