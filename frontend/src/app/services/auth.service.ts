import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = false;
  
  constructor() { }

  login(email: string, password: string): boolean {
    if (email === 'admin@test.it' && password === '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9') {
      this.loggedIn = true;
      return true;
    }
    return false;
  }

  logout(): void {
    this.loggedIn = false;
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }

}
