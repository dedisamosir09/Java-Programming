import { Component, OnInit } from '@angular/core';
import { TripsService } from "../../api_services/trips.service";
import { BusesService } from "../../api_services/buses.service";
import { StopService } from "../../api_services/stop.service";

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css']
})
export class TripsComponent implements OnInit {
  public trips: any = {};
  content?: Array<any>;
  public bus: Array<any>;
  public stop: Array<any>;

  constructor(private tripService: TripsService,
    private busService: BusesService,
    private stopService: StopService) { }

  ngOnInit(): void {
    this.tripService.getAll().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );

    this.busService.getAll().subscribe(
      data => {
        this.bus = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );

    this.stopService.getAll().subscribe(
      data => {
        this.stop = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );

  }

  public submit(): void {
    this.tripService.createTrip(this.trips).subscribe(
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
