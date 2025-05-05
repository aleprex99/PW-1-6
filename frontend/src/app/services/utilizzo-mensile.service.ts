import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UtilizzoMensile } from '../models/utilizzo-mensile.model';

@Injectable({
  providedIn: 'root'
})
export class UtilizzoMensileService {

  private baseUrl = '/UtilMens';

  constructor(private http: HttpClient) {}

  getAll(): Observable<UtilizzoMensile>{
    return this.http.get<UtilizzoMensile>(`${this.baseUrl}/getUtilMens`);
  }

  getById(id: number): Observable<UtilizzoMensile> {
    return this.http.get<UtilizzoMensile>(`${this.baseUrl}/getUtilMensById/${id}`);
  }


  create(um: UtilizzoMensile): Observable<UtilizzoMensile> {
    return this.http.post<UtilizzoMensile>(`${this.baseUrl}/insUtilMens`, um);
  }


  update(um: UtilizzoMensile): Observable<UtilizzoMensile> {
    return this.http.put<UtilizzoMensile>(`${this.baseUrl}/updUtilMens`, um);
  }

  
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteUtilMensById/${id}`);
  }

}
