import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Garanzia } from '../models/garanzia.model';

@Injectable({ providedIn: 'root' })
export class GaranziaService {
  private baseUrl = '/Garanzia';
  constructor(private http: HttpClient) {}

  getAll(): Observable<Garanzia[]> {
    return this.http.get<Garanzia[]>(`${this.baseUrl}/getGaranzie`);
  }


  getById(id: number): Observable<Garanzia> {
    return this.http.get<Garanzia>(`${this.baseUrl}/getGaranziaById/${id}`);
  }


  create(g: Garanzia): Observable<Garanzia> {
    return this.http.post<Garanzia>(`${this.baseUrl}/insGaranzia`, g);
  }


  update(g: Garanzia): Observable<Garanzia> {
    return this.http.put<Garanzia>(`${this.baseUrl}/updGaranzia`, g);
  }
  

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteGaranziaById/${id}`);
  }
}