import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {
  constructor(private router: Router) { }
  message="";
  ngOnInit() {
  }
  gotologin(){
    this.router.navigate(['login']);  }
    Register(){
      this.message="Sucessfully registerd Plese go to login page";
    }
}
