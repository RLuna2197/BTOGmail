import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Actualizar } from '../model/actualizar';
import { ApiService } from '../services/api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-lista-correo',
  templateUrl: './lista-correo.component.html',
  styleUrls: ['./lista-correo.component.css']
})


export class ListaCorreoComponent implements OnInit {
  actualizar:Actualizar= new Actualizar();
  mensajeError: string;
  correos: any[];
  urlApi: string;
  public page: number;
  modal: boolean=false;
  formularioAgregar:FormGroup;

  constructor(private dataApi: ApiService, private route: ActivatedRoute, private fb:FormBuilder) {
    this.formularioAgregar=this.fb.group({
      nombreEmisor:['',Validators.required],
      correoReceptor:['',Validators.required],
      asunto:['',Validators.required],
      mensaje:['',Validators.required]
    })
   }

  ngOnInit(): void {
    this.formularioAgregar=this.fb.group({
      nombreEmisor:['',Validators.required],
      correoReceptor:['',Validators.required],
      asunto:['',Validators.required],
      mensaje:['',Validators.required]
    })
    
    
    this.getCorreos();

   
  }

  getCorreos() {

    this.dataApi.getCorreo().subscribe((response) => {
      this.correos = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreo().subscribe((correos) => console.log(correos)); // mostrar en consola
  }

  mostrarEnviados(){
    this.dataApi.getCorreoEnviado().subscribe((response) => {
      this.correos = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreoEnviado().subscribe((correos) => console.log(correos)); // mostrar en consola
  }

  mostrarRecibidos(){
    this.getCorreos();
  }

  mostrarDestacados(){
    this.dataApi.getCorreoDestacado().subscribe((response) => {
      this.correos = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreoDestacado().subscribe((correos) => console.log(correos)); // mostrar en consola
  }

  mostrarSpam(){
    this.dataApi.getCorreoSpam().subscribe((response) => {
      this.correos = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreoSpam().subscribe((correos) => console.log(correos)); // mostrar en consola
  }

  mostrarPapelera(){

    this.dataApi.getCorreoEliminado().subscribe((response) => {
      this.correos = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreoEliminado().subscribe((correos) => console.log(correos)); // mostrar en consola
  }


  abrirModal(){
    this.modal = true;
    console.log(this.modal)
  }
  cerrarModal(){
    this.modal = false;
  }

  eliminado(correo){
    this.actualizar = correo;
    this.actualizar.spam= false;
    this.actualizar.destacado=false;
    if (this.actualizar.eliminado) {
      this.actualizar.eliminado = false;
  }
  else{ this.actualizar.eliminado = true;}

    this.dataApi.actualizar(this.actualizar).subscribe((response) => {
      this.actualizar = response;
    },
      (error) => { console.error(error); }
    );

    //this.dataApi.getCorreo().subscribe((correos) => console.log(correos)); // mostrar en consola

  }

  Importante(correo){
    this.actualizar = correo;
    this.actualizar.destacado = !this.actualizar.destacado;
    this.dataApi.actualizar(this.actualizar).subscribe((response) => {
      this.actualizar = response;
    },
      (error) => { console.error(error); }
    );

    this.dataApi.getCorreo().subscribe((correos) => console.log(correos)); // mostrar en consola

    
  }

  Spam(correo){
    this.actualizar = correo;
    this.actualizar.eliminado =false;
    this.actualizar.destacado=false;
    if (this.actualizar.spam) {
        this.actualizar.spam = false;
    }
    else{ this.actualizar.spam = true;}

    this.dataApi.actualizar(this.actualizar).subscribe((response) => {
      this.actualizar = response;
    },
      (error) => { console.error(error); }
    );

    //this.dataApi.getCorreo().subscribe((correos) => console.log(correos)); // mos

  }
  leer(correo){
    this.actualizar = correo;
    console.log("Leido .....")
    if (this.actualizar.leido) {
        this.actualizar.leido = false;
    }
    else{ this.actualizar.leido = true;}

    this.dataApi.actualizar(this.actualizar).subscribe((response) => {
      this.actualizar = response;
    },
      (error) => { console.error(error); }
    );
  }

  agregar(){
    
    this.actualizar=this.formularioAgregar.value as Actualizar;
    
    console.log(this.actualizar)
    this.dataApi.agregar(this.actualizar).subscribe((response) => {
      this.actualizar = response;
    },
      (error) => { console.error(error); }
    );
    this.formularioAgregar.reset();
    
  }

}
