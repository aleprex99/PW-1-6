import { Injectable } from '@angular/core';
import { Cliente } from '../models/cliente.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private baseUrl = '/Cliente';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.baseUrl}/getClienti`);
  }


  getById(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.baseUrl}/getClienteById/${id}`);
  }


  getClienteByNome(nome:string): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.baseUrl}/getClienteByNome/${nome}`);
  }
  
  
  getClienteByCognome(cognome:string): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.baseUrl}/getClienteByCognome/${cognome}`);
  }


  create(c: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.baseUrl}/insCliente`, c);
  }


  update(c: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${this.baseUrl}/updCliente`, c);
  }


  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteClienteById/${id}`);
  }

}
