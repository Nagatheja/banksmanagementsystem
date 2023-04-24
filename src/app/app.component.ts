import { Component,OnInit } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'BankManagementSystem';
  constructor(public loginService:AuthenticationService,private router: Router) { }
  ngOnInit() {
    
   
  }
  conformLogout(){
    var status= confirm("You want to  Logout");
     if (status==true) {
      this.router.navigate(["/logout"]);
      console.log("navigate..");
          }
     else{
      this.router.navigate(["/banks"]);
      console.log("navigate..");
          }
        }
}
