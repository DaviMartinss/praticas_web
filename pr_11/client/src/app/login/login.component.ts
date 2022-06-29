import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  loginFailMessage: string = '';

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  login(){
    console.log('login - ' + this.username + ':' + this.password);
    this.loginService.login(this.username, this.password).subscribe((user) => {
      console.log('USER/ME: ');
      console.log(user);
    }, (error) => {
      this.loginFailMessage = 'Usuario ou senha invalidos. Tente novamente';
    });
  }

}
