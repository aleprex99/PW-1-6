import { Component } from '@angular/core';
import { Polizza } from '../../../../models/polizza.model';
import { ActivatedRoute } from '@angular/router';
import { PolizzaService } from '../../../../services/polizza.service';
import { VeicoloService } from '../../../../services/veicolo.service';
import { Veicolo } from '../../../../models/veicolo.model';
import { Cliente } from '../../../../models/cliente.model';
import { ClienteService } from '../../../../services/cliente.service';

import jsPDF from 'jspdf';
import { autoTable } from 'jspdf-autotable'
import { Garanzia } from '../../../../models/garanzia.model';
import { GaranziaService } from '../../../../services/garanzia.service';
import { UtilizzoMensileService } from '../../../../services/utilizzo-mensile.service';
import { UtilizzoMensile } from '../../../../models/utilizzo-mensile.model';

interface PolizzaCompleta extends Polizza {
  veicolo: Veicolo;
  utilizzoMensile: UtilizzoMensile
}

@Component({
  selector: 'app-dettaglio-polizza',
  templateUrl: './dettaglio-polizza.component.html',
  styleUrl: './dettaglio-polizza.component.scss'
})
export class DettaglioPolizzaComponent {
  
  polizza: Polizza;
  cliente: Cliente;
  veicolo: Veicolo;
  utilizzoMensile: UtilizzoMensile;

  allGaranzie: Garanzia[] = [
    // { id: 1, nome: "Furto e Incendio", descr: "Proteggiti dagli imprevisti", costo: 4000 },
    // { id: 2, nome: "Assistenza stradale", descr: "Al tuo servizio 24h", costo: 1500 },
    // { id: 3, nome: "Assistenza legale", descr: "Per supportarti sempre", costo: 2300 },
    // { id: 4, nome: "Infortuni conducente", descr: "Per la tua salute", costo: 3300 }
  ];

  selectedGaranzie:any[] = [];
  loading = false;
  errorMessage = '';

  kmMeter = [
    { label: 'Utilizzo km gratuiti', value: 100, color: '#6366F1' }
  ];

  infoVeicoloDialogVisible = false;
  
  constructor(
    private route: ActivatedRoute,
    private polizzaService: PolizzaService,
    private clienteService: ClienteService,
    private veicoloService: VeicoloService,
    private garanziaService: GaranziaService,
    private utilizzoMensileService: UtilizzoMensileService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.loading = true;

    this.garanziaService.getAll().subscribe({ next: list => this.allGaranzie = list });
    
    this.polizzaService.getById(id).subscribe({
      next: p => {
        this.polizza = p;
        this.selectedGaranzie = [...(p as any).garanzieIds];
        this.loadCliente((p as any).clienteId);
        this.loadVeicolo((p as any).veicolo.id);
        this.loading = false;
      },
      error: () => { this.errorMessage = 'Errore caricamento polizza'; this.loading = false; }
    });
  }


  loadCliente(clienteId: number) {
    this.clienteService.getById(clienteId).subscribe(c => this.cliente = c);
  }


  loadVeicolo(veicoloId: number) {
    this.veicoloService.getById(veicoloId).subscribe(v => this.veicolo = v);
  }


  toggleGaranzia(id: number) {
    if (this.selectedGaranzie.includes(id)) {
      this.selectedGaranzie = this.selectedGaranzie.filter(g => g !== id);
    } else {
      this.selectedGaranzie.push(id);
    }
  }


  getKmEccedenti() {
    return Math.max(0, this.utilizzoMensile.kmPercorsi - this.polizza.kmInclusiMensili);
  }


  getSelectedGaranzie() {
    const selectedGaranzie = [];
    for(let i = 0; i < this.allGaranzie.length; i++) {
      const garanzia = this.allGaranzie[i];
      if(this.selectedGaranzie.includes(garanzia.id)) {
        selectedGaranzie.push(garanzia);
      }
    }
    return selectedGaranzie;
  }


  sumGaranzieAccessorieImporto() {
    let importo = 0;
    for(let i = 0; i < this.selectedGaranzie.length; i++) {
      const garanzia = this.selectedGaranzie[i];
      importo += Number(garanzia.costo);
    }

    return importo;
  }


  saveGaranzie() {
    this.utilizzoMensileService.update(this.utilizzoMensile).subscribe({
      next: updated => this.utilizzoMensile = updated,
      error: () => this.errorMessage = 'Errore aggiornamento garanzie'
    });
  }


  showInfoVeicolo() {
    this.infoVeicoloDialogVisible = true;
  }


  formatCurrency(currencyValue) {
    const formatted = new Intl.NumberFormat('de-DE', {
      style: 'currency',
      currency: 'EUR'
    }).format(currencyValue / 100);

    return formatted;
  }


  getCostoMensileEffettivo() {
    return Number(this.polizza.quotaMensile) + Number(this.getConguaglio()) + Number(this.sumGaranzieAccessorieImporto());
  }


  getConguaglio() {
    const kmEccedenti = Math.max(0, (this.polizza as PolizzaCompleta).utilizzoMensile.kmPercorsi - this.polizza.kmInclusiMensili);
    const conguaglio = this.polizza.costoKmExtra * kmEccedenti;

    return conguaglio;
  }


  generaCertificatoPolizza(): void {
    const doc = new jsPDF({ unit: 'pt', format: 'a4' });
    const margin = 40;
    const pageWidth = doc.internal.pageSize.getWidth();

    // Logo
    const img = new Image();
    img.src = 'assets/flexikm_logo.png';
    const logoWidth = 96;
    const logoHeight = 27;

    img.onload = () => {
      doc.addImage(img, 'PNG', (pageWidth / 2) - (logoWidth / 2), 40, logoWidth, logoHeight);

      // Titolo
      doc.setFont('helvetica', 'bold');
      doc.setFontSize(22);
      doc.setTextColor('#6366f1');
      doc.text('Certificato di assicurazione', pageWidth / 2, 90, { align: 'center' });

      // Header
      doc.setTextColor(0);
      doc.setFont('helvetica', 'normal');
      doc.setFontSize(12);
      const headerY = 120;
      doc.text(`Targa: ${this.veicolo.targa}`, margin, headerY);
      doc.text(`N° Polizza: ${this.polizza.id}`, margin + 200, headerY);
      doc.text(`Decorrenza: ${new Date(this.polizza.dataInizio).toLocaleDateString()}`, margin + 380, headerY);

      // Separatore
      doc.setDrawColor('#6366f1');
      doc.setLineWidth(1);
      doc.line(margin, headerY + 15, pageWidth - margin, headerY + 15);

      // Contraente
      const section2Y = headerY + 40;
      doc.setFont('helvetica', 'bold');
      doc.setTextColor('#6366f1');
      doc.text('Contraente', margin, section2Y);
      doc.setFont('helvetica', 'normal');
      doc.setTextColor(0);
      doc.text(`${this.cliente.nome} ${this.cliente.cognome}`, margin, section2Y + 20);
      doc.text(`Indirizzo: ${this.cliente.indirizzo || ''}`, margin, section2Y + 40);

      // Dati Veicolo
      const veicoloY = section2Y + 70;
      doc.setFont('helvetica', 'bold');
      doc.setTextColor('#6366f1');
      doc.text('Dati Veicolo', margin, veicoloY);

      autoTable(doc, {
        startY: veicoloY + 10,
        margin: { left: margin, right: margin },
        head: [[
          { content: 'Marca', styles: { fillColor: '#6366f1', textColor: 255 } },
          { content: 'Modello', styles: { fillColor: '#6366f1', textColor: 255 } },
          { content: 'Anno', styles: { fillColor: '#6366f1', textColor: 255 } },
          { content: 'Targa', styles: { fillColor: '#6366f1', textColor: 255 } }
        ]],
        body: [[
          this.veicolo.marca,
          this.veicolo.modello,
          `${this.veicolo.annoImmatr}`,
          this.veicolo.targa
        ]],
        styles: { font: 'helvetica', fontSize: 12 }
      });
      
      // Garanzie
      const afterVeicoloY = (doc as any).lastAutoTable.finalY + 30;
      doc.setFont('helvetica', 'bold');
      doc.setTextColor('#6366f1');
      doc.text('Garanzie Attive', margin, afterVeicoloY);
      autoTable(doc, {
        startY: afterVeicoloY + 10,
        margin: { left: margin, right: margin },
        headStyles: { fillColor: '#6366f1', textColor: 255, fontStyle: 'bold' },
        bodyStyles: { textColor: 0 },
        head: [['Garanzia', 'Costo Attivazione']],
        body: this.allGaranzie
          .filter(g => this.selectedGaranzie.includes(g.id))
          .map(g => [g.nome, g.costo.toFixed(2)])
      });

      // Sezione Dati Polizza
      const finalY = (doc as any).lastAutoTable.finalY + 30;
      doc.setFont('helvetica', 'bold');
      doc.setTextColor('#6366f1');
      doc.text('Dati Polizza', margin, finalY);
      doc.setFont('helvetica', 'normal');
      doc.setTextColor(0);
      doc.text(`Quota Mensile: €${this.polizza.quotaMensile}`, margin, finalY + 20);
      doc.text(`Km Inclusi Base: ${this.polizza.kmInclusiMensili}`, margin + 200, finalY + 20);
      doc.text(`Costo Km Extra: €${this.polizza.costoKmExtra}`, margin + 400, finalY + 20);

      // Footer
      const pageHeight = doc.internal.pageSize.getHeight();
      doc.setFontSize(10);
      doc.setTextColor(100);
      doc.text('FlexiKm, l\'assicurazione Pay per Km.', margin, pageHeight - 30);

      doc.save(`polizza_${this.polizza.id}.pdf`);
    };
  }
}
