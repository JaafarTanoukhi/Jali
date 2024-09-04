import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LogInComponent } from "./Auth/log-in/log-in.component";
import { SignupCustomerComponent } from "./Auth/signup-customer/signup-customer.component";
import { SignupSellerComponent } from "./Auth/signup-seller/signup-seller.component";



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LogInComponent, SignupCustomerComponent, SignupSellerComponent],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'jali-frontend';
  message = 'The messages are : ';

}