export class Sinistro {
  constructor(
    public id: number,
    public numSinistro: string,
    public dataSinistro: Date,
    public luogo: string,
    public tipo: string,
    public descr: string,
    public nome: string,
    public cognome: string,
    public cf: string,
    public email: string,
    public tel: string,
    public indirizzo: string,
    public patenteNumero: string,
    public stato: 'aperto' | 'in lavorazione' | 'chiuso'
  ) {}
}