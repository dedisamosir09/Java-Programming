import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../api_services/token-storage.service';
import { Router } from "@angular/router"


@Component({
  selector: 'app-templates',
  templateUrl: './templates.component.html'
})
export class TemplatesComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService, private router: Router) {
    if (this.tokenStorage.getToken() == null) {
      this.router.navigate(['/login']);
    }
  }

  ngOnInit(): void {
  }

  public logout(): void {
    this.tokenStorage.signOut();
    window.location.reload();
  }
}
