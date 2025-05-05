export class Veicolo {
  constructor(
    public id: number,
    public marca: string,
    public modello: string,
    public annoImmatr: number,
    public targa: string,
    public valore: number
  ) {}
}