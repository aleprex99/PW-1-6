export class Garanzia {
  constructor(
    public id: number,
    public nome: string,
    public descr: string | undefined,
    public costo: number
  ) {}
}