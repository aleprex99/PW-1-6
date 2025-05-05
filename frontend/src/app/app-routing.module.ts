import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { loggedInGuard, notLoggedInGuard } from './guards/auth.guard';
import { PolizzeComponent } from './pages/dashboard/polizze/polizze.component';
import { DettaglioPolizzaComponent } from './pages/dashboard/polizze/dettaglio-polizza/dettaglio-polizza.component';
import { PreventiviComponent } from './pages/dashboard/preventivi/preventivi.component';
import { DenunciaSinistroComponent } from './pages/dashboard/denuncia-sinistro/denuncia-sinistro.component';

const routes: Routes = [
  { 
    path: '', 
    redirectTo: 'login',
    pathMatch: 'full' 
  },
  { 
    path: 'login',
    component: LoginComponent,
    canActivate: [notLoggedInGuard]
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [loggedInGuard],
    children: [
      { path: '', redirectTo: 'polizze', pathMatch: 'full' },
      { path: 'polizze', component: PolizzeComponent },
      { path: 'polizze/:id', component: DettaglioPolizzaComponent },
      { path: 'preventivi', component: PreventiviComponent },
      { path: 'preventivi/:id', component: DettaglioPolizzaComponent },
      { path: 'denunciaSinistro', component: DenunciaSinistroComponent },
    ]
  },
  { 
    path: '**', 
    redirectTo: 'login'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
