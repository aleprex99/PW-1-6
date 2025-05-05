import { Component } from '@angular/core';
import { Polizza } from '../../../models/polizza.model';
import { PolizzaService } from '../../../services/polizza.service';
import { Router } from '@angular/router';
import { VeicoloService } from '../../../services/veicolo.service';
import { forkJoin } from 'rxjs';
import { Veicolo } from '../../../models/veicolo.model';
import { UtilizzoMensile } from '../../../models/utilizzo-mensile.model';

interface PolizzaCompleta extends Polizza {
  veicolo: Veicolo;
  utilizzoMensile: UtilizzoMensile
}

@Component({
  selector: 'app-polizze',
  templateUrl: './polizze.component.html',
  styleUrl: './polizze.component.scss'
})
export class PolizzeComponent {
  polizze: PolizzaCompleta[] = [];
  loading = false;
  errorMessage = '';

  constructor(private polizzaService: PolizzaService, private veicoloService:VeicoloService, private router: Router) {}

  ngOnInit(): void {
    this.loadPolizze();
  }


  loadPolizze(): void {
    this.loading = true;
    this.polizzaService.getAll().subscribe({
      next: (data) => {
        const calls = data.map(p => this.veicoloService.getById(p.veicolo.id));
        forkJoin(calls).subscribe({
          next: vehicles => {
            this.polizze = data.map((p, i) => ({ ...p, veicolo: vehicles[i], utilizzoMensile: null }));
            this.loading = false;
          },
          error: () => {
            this.errorMessage = 'Errore nel caricamento veicoli';
            this.loading = false;
          }
        });
      },
      error: () => {
        this.errorMessage = 'Errore nel caricamento polizze';
        this.loading = false;
      }
    });
  }



  deletePolizza(id: number): void {
    this.polizzaService.delete(id).subscribe({
      next: () => this.loadPolizze(),
      error: () => this.errorMessage = 'Errore nella cancellazione'
    });
  }

  
  goToDettaglio(id: number): void {
    this.router.navigate(['dashboard', 'polizze', id]);
  }


  getConguaglio(polizza:PolizzaCompleta) {
    const kmEccedenti = Math.max(0, polizza.utilizzoMensile.kmPercorsi - polizza.kmInclusiMensili);
    const conguaglio = polizza.costoKmExtra * kmEccedenti;

    const conguaglioFormatted = new Intl.NumberFormat('de-DE', {
      style: 'currency',
      currency: 'EUR'
    }).format(conguaglio);

    return conguaglioFormatted;
  }
}
