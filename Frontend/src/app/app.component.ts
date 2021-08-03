import { Component } from '@angular/core';
import { TokenStorageService } from './api_services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'final-project';

  constructor(private tokenStorageService: TokenStorageService) { }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
