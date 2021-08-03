import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from "./token-storage.service";

const STOP_API = 'http://localhost:8080/api/v1/stop/';

@Injectable({
  providedIn: 'root'
})
export class StopService {
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {
  }

  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.tokenStorage.getToken()
    })
  };

  getAll(): Observable<any> {
    return this.http.get<any>(STOP_API, this.httpOptions);
  }

}