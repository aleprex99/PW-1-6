export class Cliente {
  constructor(
    public id: number,
    public password: string,
    public attivo: boolean,
    public nome: string,
    public cognome: string,
    public cf: string,
    public nazionalita: string,
    public email: string,
    public tel: string,
    public indirizzo: string,
    public eta: number,
    public classeMerito: string,
    public docNumero: string,
    public tipoDoc: string
  ) {}
}