import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from "./token-storage.service";


const API_URL = 'http://localhost:8080/api/v1/user/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) { }

  public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.tokenStorage.getToken()
    })
  };

  getUserData(): Observable<any> {
    return this.http.get(API_URL, this.httpOptions);
  }

  updateData(data: any): Observable<any> {
    return this.http.put(API_URL, data, this.httpOptions);
  }

  updatePassword(data: any): Observable<any> {
    return this.http.put(API_URL + 'password', data, this.httpOptions);
  }
}
