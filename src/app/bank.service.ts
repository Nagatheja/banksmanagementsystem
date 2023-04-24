import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Bank } from './bank';

@Injectable({
  providedIn: 'root'
})
export class BankService {

  private baseURL = "http://localhost:8090/api/v1/bank";

  constructor(private httpClient: HttpClient) { }
  
  getBankList(): Observable<Bank[]>{
    return this.httpClient.get<Bank[]>(`${this.baseURL}`);
  }

  createBank(bank: Bank): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, bank);
  }

  getBankById(id: number): Observable<Bank>{
    return this.httpClient.get<Bank>(`${this.baseURL}/${id}`);
  }

  updateBank(id: number, bank: Bank): Observable<Object>{
    console.log(id);
    console.log(bank);
    return this.httpClient.put(`${this.baseURL}/${id}`, bank);
  }

  //localhost:4200/delete/5
  deleteBank(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}` );
  }
  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}`);
  }
  
	findByName(name: any): Observable<Bank[]> {
    return this.httpClient.get<Bank[]>(`${this.baseURL}?name=${name}`);
  }
  findByCityMadanapalle(): Observable<Bank[]>{
    return this.httpClient.get<Bank[]>(`${this.baseURL}/fetchByCityMadanapalle`);
  }
  findByCityAnantapur(): Observable<Bank[]>{
    return this.httpClient.get<Bank[]>(`${this.baseURL}/fetchByCityAnantapur`);
  }
  findByCityBukkapatnam(): Observable<Bank[]>{
    return this.httpClient.get<Bank[]>(`${this.baseURL}/fetchByCityBukkapatnam`);
  }
}