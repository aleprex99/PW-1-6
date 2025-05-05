import { Sinistro } from "./sinistro.model";
import { Veicolo } from "./veicolo.model";

export class Polizza {
  constructor(
    public id: number,
    public numeroPolizza: string,
    public veicolo: Veicolo,
    public dataInizio: Date,
    public durata: number,
    public stato: 'attiva' | 'scaduta' | 'sospesa',
    public quotaMensile: number,
    public kmInclusiMensili: number,
    public costoKmExtra: number,
    public guidaEsclusiva: boolean,
    public sinistri: Sinistro[]
  ) {}
}