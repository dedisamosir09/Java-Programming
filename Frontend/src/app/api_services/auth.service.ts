import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'auth', {
      username,
      password
    }, httpOptions);
  }

  register(username: string, firstName: string, lastName:string,mobileNumber:string, role:any, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'v1/user/signup', {
      username,
      password,
      firstName,
      lastName,
      mobileNumber,
      role
    }, httpOptions);
  }

  registerAgency(name: string, details:string,code:string  ): Observable<any>{
    return this.http.post('http://localhost:8080/api/v1/agency/',{
      name,
      details,
      code
    }, httpOptions); 
  }
}
