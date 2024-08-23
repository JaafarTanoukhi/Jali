import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'jali-frontend';
  message = 'The messages are : ';

  constructor(){
    this.fetchMessage();
  }

 async fetchMessage(){
    const response = await fetch('http://localhost:8080/api/metadata/describe',{
      mode : 'cors',
      method :'get'
    })
    console.log(response);
    const result = await response.json()
    console.log(result);
    this.message += result;
  }
}
