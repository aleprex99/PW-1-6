import { Injectable } from '@angular/core';
import { Veicolo } from '../models/veicolo.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VeicoloService {

  private baseUrl = '/Veicolo';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Veicolo[]> {
    return this.http.get<Veicolo[]>(`${this.baseUrl}/getVeicoli`);
  }


  getById(id: number): Observable<Veicolo> {
    return this.http.get<Veicolo>(`${this.baseUrl}/getVeicoloById/${id}`);
  }


  create(v: Veicolo): Observable<Veicolo> {
    return this.http.post<Veicolo>(`${this.baseUrl}/insVeicolo`, v);
  }


  update(v: Veicolo): Observable<Veicolo> {
    return this.http.put<Veicolo>(`${this.baseUrl}/updVeicolo`, v);
  }


  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteVeicoloById/${id}`);
  }

}
