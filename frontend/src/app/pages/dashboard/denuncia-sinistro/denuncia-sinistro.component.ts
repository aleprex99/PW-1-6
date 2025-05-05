import { Component, EventEmitter, Output } from '@angular/core';
import { Sinistro } from '../../../models/sinistro.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SinistroService } from '../../../services/sinistro.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-denuncia-sinistro',
  templateUrl: './denuncia-sinistro.component.html',
  styleUrl: './denuncia-sinistro.component.scss'
})
export class DenunciaSinistroComponent {
  @Output() sinistroCreato = new EventEmitter<Sinistro>();
  form: FormGroup;

  tipiSinistro = ['Tamponamento', 'Furto', 'Incendio', 'Altro'];
  stati = ['aperto', 'in lavorazione', 'chiuso'];

  constructor(private fb: FormBuilder, private sinistroService:SinistroService, private messageService: MessageService) {
    this.form = this.fb.group({
      numSinistro: ['', Validators.required],
      dataSinistro: [null, Validators.required],
      luogo: ['', Validators.required],
      tipo: ['', Validators.required],
      descr: [''],
      nome: ['', Validators.required],
      cognome: ['', Validators.required],
      cf: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      tel: ['', Validators.required],
      indirizzo: ['', Validators.required],
      patenteNumero: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      const nuovoSinistro = new Sinistro(
        0,
        null,
        this.form.value.dataSinistro,
        this.form.value.luogo,
        this.form.value.tipo,
        this.form.value.descr,
        this.form.value.nome,
        this.form.value.cognome,
        this.form.value.cf,
        this.form.value.email,
        this.form.value.tel,
        this.form.value.indirizzo,
        this.form.value.patenteNumero,
        null
      );
      
      this.sinistroService.create(nuovoSinistro).subscribe({
        next: () => {
          this.messageService.add({
            severity: 'success',
            summary: 'Successo',
            detail: 'Sinistro registrato con successo'
          });
          this.form.reset();
        },
        error: (err) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Errore',
            detail: 'Errore durante la registrazione del sinistro'
          });
          console.error(err);
        }
      });

    }
  }
}
