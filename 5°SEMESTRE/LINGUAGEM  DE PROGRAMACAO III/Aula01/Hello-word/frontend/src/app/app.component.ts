import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message: string = '';

  constructor(private http: HttpClient) {
    this.http.get('http://localhost:8080/api/hello',{responseType: 'text'}).subscribe((res: any) => {
      this.message = res;
    });
    
  }
}
