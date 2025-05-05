import { Garanzia } from "./garanzia.model";

export class UtilizzoMensile {
  constructor(
    public id: number,
    public polizzaId: number,
    public anno: number,
    public mese: number,
    public kmPercorsi: number,
    public garanzie: Garanzia[]
  ) {}
}