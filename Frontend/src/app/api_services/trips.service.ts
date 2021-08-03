import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from "./token-storage.service";

const BUS_API = 'http://localhost:8080/api/v1/trip/';

@Injectable({
  providedIn: 'root'
})
export class TripsService {
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {
  }

  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.tokenStorage.getToken()
    })
  };

  getAll(): Observable<any> {
    return this.http.get<any>(BUS_API, this.httpOptions);
  }

  createTrip(data: any): Observable<any> {
    return this.http.post(BUS_API, data, this.httpOptions);
  }
}