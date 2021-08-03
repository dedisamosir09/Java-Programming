import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from "./token-storage.service";

const AGENCY_API = 'http://localhost:8080/api/v1/agency/';

@Injectable({
  providedIn: 'root'
})
export class AgencyService {
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {
  }

  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.tokenStorage.getToken()
    })
  };

  getAll(): Observable<any> {
    return this.http.get<any>(AGENCY_API, this.httpOptions);
  }

  updateAgency(data: any): Observable<any> {
    return this.http.put(AGENCY_API, data, this.httpOptions);
  }
}