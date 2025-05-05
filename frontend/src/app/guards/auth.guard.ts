import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

// export const authGuard: CanActivateFn = (route, state) => {
//   const auth = inject(AuthService);
//   const router = inject(Router);

//   if (auth.isLoggedIn()) {
//     return true;
//   } else {
//     return router.createUrlTree(['/login']);
//   }
// };

export const loggedInGuard = async () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const isAuth = authService.isLoggedIn();
  if (isAuth) {
    return true;
  } else {
    router.navigate(['/login']);
    return false;
  }
};

export const notLoggedInGuard = async () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const isAuth = authService.isLoggedIn();
  if (isAuth) {
    router.navigate(['/dashboard']);
    return false;
  } else {
    return true;
  }
};