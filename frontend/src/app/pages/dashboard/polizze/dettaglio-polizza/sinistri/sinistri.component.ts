import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Sinistro } from '../../../../../models/sinistro.model';
import { SinistroService } from '../../../../../services/sinistro.service';

@Component({
  selector: 'app-sinistri',
  templateUrl: './sinistri.component.html',
  styleUrl: './sinistri.component.scss'
})
export class SinistriComponent {

  @Input() polizzaId!: number;
  
  sinistri: Sinistro[] = [];
  form!: FormGroup;
  loading = false;
  errorMessage = '';
  showForm = false;

  constructor(
    private sinistroService: SinistroService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.initForm();
    this.loadSinistri();
  }


  private initForm(): void {
    this.form = this.fb.group({
      tipo: ['', Validators.required],
      descrizione: ['', Validators.required],
      dataApertura: [new Date(), Validators.required],
      importoStimato: [0, [Validators.min(0)]]
    });
  }


  loadSinistri(): void {
    this.loading = true;
    this.sinistroService.getAllByPolizza(this.polizzaId).subscribe({
      next: data => { this.sinistri = data; this.loading = false; },
      error: () => { this.errorMessage = 'Errore nel caricamento sinistri'; this.loading = false; }
    });
  }


  toggleForm(): void {
    this.showForm = !this.showForm;
  }


  submit(): void {
    if (this.form.invalid) return;
    const newSinistro: Sinistro = {
      id: 0,
      polizzaId: this.polizzaId,
      stato: 'aperto',
      ...this.form.value
    };
    this.sinistroService.create(newSinistro).subscribe({
      next: () => {
        this.loadSinistri();
        this.form.reset({ dataApertura: new Date(), importoStimato: 0 });
        this.showForm = false;
      },
      error: () => this.errorMessage = 'Errore nella creazione'
    });
  }


  delete(id: number): void {
    this.sinistroService.delete(id).subscribe({
      next: () => this.loadSinistri(),
      error: () => this.errorMessage = 'Errore nella cancellazione'
    });
  }
}
