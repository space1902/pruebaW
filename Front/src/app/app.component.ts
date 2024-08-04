import { Component } from '@angular/core';
import { GithubService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Buscador de usuarios de GitHub';
  users: any[] = [];
  query: string = '';

  constructor(private githubService: GithubService) { }

  searchUsers() {
    if (this.query) {
      this.githubService.searchUsers(this.query).subscribe(
        data => {
          this.users = data.items;
        },
        error => {
          console.error('Error fetching data', error);
        }
      );
    }
  }
}
