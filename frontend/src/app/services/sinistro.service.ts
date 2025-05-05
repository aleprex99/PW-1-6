import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sinistro } from '../models/sinistro.model';

@Injectable({ providedIn: 'root' })
export class SinistroService {

  private baseUrl = '/Sinistro';

  constructor(private http: HttpClient) {}

  getAllByPolizza(polizzaId: number): Observable<Sinistro[]> {
    return this.http.get<Sinistro[]>(`${this.baseUrl}/getSinistriByIdPolizza/${polizzaId}`);
  }


  getById(id: number): Observable<Sinistro> {
    return this.http.get<Sinistro>(`${this.baseUrl}/getSinistroById/${id}`);
  }


  create(s: Sinistro): Observable<Sinistro> {
    return this.http.post<Sinistro>(`${this.baseUrl}/insSinistro`, s);
  }


  update(s: Sinistro): Observable<Sinistro> {
    return this.http.put<Sinistro>(`${this.baseUrl}/updSinistro`, s);
  }

  
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteSinistroById/${id}`);
  }
}