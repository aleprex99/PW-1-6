import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SHA256 } from 'crypto-js';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  protected loginError:boolean = false;
  
  protected loginForm: FormGroup;

  constructor(private auth: AuthService, private router: Router) {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }
  

  onSubmit() {
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
      const success = this.auth.login(this.loginForm.value.email, SHA256(this.loginForm.value.password).toString());
      if (success) {
        this.router.navigate(['/dashboard']);
      } else {
        this.loginError = true;
      }
    }
    else {
      console.log('Form non valido!');
    }
  }
}
