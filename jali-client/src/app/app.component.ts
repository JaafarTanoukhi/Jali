import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { createAuth } from '../java/Auth';


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
  const returnedNumber = await createAuth(12);
 }
}
