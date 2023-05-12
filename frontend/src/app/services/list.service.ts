import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Beneficiario } from '../interfaces/beneficiario';



@Injectable({
  providedIn: 'root'
})
export class ListService {

  private baseUrl = 'http://localhost:8080'

  constructor(private http: HttpClient) { }

  // postBeneficiario(): Observable<[]>{
  //   return this.baseUrl
  // }

  getBeneficiarios(): Observable<Beneficiario[]> {
    return this.http.get<Beneficiario[]>('localhost:8080/beneficiario');
  }


}
