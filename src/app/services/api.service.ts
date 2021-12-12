import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http,Headers, RequestOptions,RequestMethod } from '@angular/http';
import { Actualizar } from '../model/actualizar';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  getCorreo() {
    

     const urlApi = 'http://localhost:7000/Correos/0';
     const httpOptions = {
      headers: new HttpHeaders({
      'Access-Control-Allow-Origin':'*',
      'Content-Type': 'application/json'
      })
      };
    return this.http.get<any>(urlApi,httpOptions);

    
    
   // return this.http.get(urlApi , options).map((res) => res.json());

  }

  getCorreoEnviado() {
    

    const urlApi = 'http://localhost:7000/Correos/1';
    const httpOptions = {
     headers: new HttpHeaders({
     'Access-Control-Allow-Origin':'*',
     'Content-Type': 'application/json'
     })
     };
   return this.http.get<any>(urlApi,httpOptions);

 }

 getCorreoSpam() {
    

  const urlApi = 'http://localhost:7000/CorreosSpam/1';
  const httpOptions = {
   headers: new HttpHeaders({
   'Access-Control-Allow-Origin':'*',
   'Content-Type': 'application/json'
   })
   };
 return this.http.get<any>(urlApi,httpOptions);

}


getCorreoEliminado() {
    

  const urlApi = 'http://localhost:7000/CorreosEliminados/1';
  const httpOptions = {
   headers: new HttpHeaders({
   'Access-Control-Allow-Origin':'*',
   'Content-Type': 'application/json'
   })
   };
 return this.http.get<any>(urlApi,httpOptions);

}

getCorreoDestacado() {
    

  const urlApi = 'http://localhost:7000/CorreosDestacados/1';
  const httpOptions = {
   headers: new HttpHeaders({
   'Access-Control-Allow-Origin':'*',
   'Content-Type': 'application/json'
   })
   };
 return this.http.get<any>(urlApi,httpOptions);

}

actualizar(objeto: Actualizar){
  console.log("Api");
  console.log(objeto);
  const urlApi = 'http://localhost:7000/Correos/';
  const httpOptions = {
   headers: new HttpHeaders({
   'Access-Control-Allow-Origin':'*',
   'Content-Type': 'application/json'
   })
   };
 return this.http.put<any>(urlApi,objeto);
}

agregar(objeto: Actualizar){
  console.log("Api");
  
  objeto.correoEmisor= objeto.nombreEmisor;
  objeto.destacado=false;
  objeto.eliminado=false;
  objeto.leido=false;
  objeto.spam=false;
  objeto.categoria=true;
  objeto.fecha="2021-10-22T04:10:10.000+00:00";
  console.log(objeto);
  const urlApi = 'http://localhost:7000/Correos';
  const httpOptions = {
   headers: new HttpHeaders({
   'Access-Control-Allow-Origin':'*',
   'Content-Type': 'application/json'
   })
   };
 return this.http.post<any>(urlApi,objeto);
}

}
