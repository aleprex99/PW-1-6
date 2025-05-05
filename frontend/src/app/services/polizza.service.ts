import { Injectable } from '@angular/core';
import { Polizza } from '../models/polizza.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolizzaService {

  private baseUrl = '/Polizza';
  
  constructor(private http: HttpClient) {}

  getAll(): Observable<Polizza[]> {
    return this.http.get<Polizza[]>(`${this.baseUrl}/getPolizze`);
  }


  getById(id: number): Observable<Polizza> {
    return this.http.get<Polizza>(`${this.baseUrl}/getPolizzaById/${id}`);
  }
  
  
  getByClienteId(id: number): Observable<Polizza> {
    return this.http.get<Polizza>(`${this.baseUrl}/getPolizzaByClienteId/${id}`);
  }


  create(g: Polizza): Observable<Polizza> {
    return this.http.post<Polizza>(`${this.baseUrl}/insPolizza`, g);
  }


  update(g: Polizza): Observable<Polizza> {
    return this.http.put<Polizza>(`${this.baseUrl}/updPolizza`, g);
  }

  
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deletePolizzaById/${id}`);
  }
  
}
