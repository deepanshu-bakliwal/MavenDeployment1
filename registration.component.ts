import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegistrationService } from './registration.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  users: User = new User();
  response: string;

  keyPress(event: any) {
    const pattern = /[0-9\+\-\ ]/;
    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
  }

  constructor(public rs: RegistrationService, private router: Router) { }

  regForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)]),
    confirm_password: new FormControl('', [Validators.required, Validators.minLength(8)]),
    dob: new FormControl('', Validators.required),
    phone_no: new FormControl('', Validators.required)

  })

  ngOnInit() {
  }

  register(pform) {
    let url = "http://localhost:8084/addUser";
    console.log(this.users);
    this.rs.retriveFromServer(url, this.users).subscribe(data => {
      console.log(data);
      this.response = data['status'];

      if(this.response === 'registration successfully!') {
        this.router.navigate(['./user_login']);
      }
      else{
        this.router.navigate(['./registration']);
      }
    });
  }
}
