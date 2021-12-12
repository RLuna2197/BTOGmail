package com.bto.correo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.bto.correo.dto.Correo;
import com.bto.correo.dto.CorreoResponse;
import com.bto.correo.interfaz.ICorreoService;

@RestController
@CrossOrigin(origins = "*")
public class CorreoController {
	@Autowired
	private ICorreoService correoService;
	
	//BUSCAR CORREOS

		@GetMapping(value="/correos", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<Correo> getCorreos(){
			List<Correo> listado = correoService.findAll();
			return listado;
		}
		
		
		//BUSCAR CORREOS RECIBIDOS=0 ENVIADOS=1
				@GetMapping(value="/Correos/{Categoria}", produces = {MediaType.APPLICATION_JSON_VALUE})
				public List<Correo> getPrestamo(@PathVariable(name="Categoria") Boolean Categoria){
					List<Correo> correo = correoService.findByRecibidos(Categoria);
					return correo;
				}
				
	  //BUSCAR CORREOS SPAM RECIBIDOS=0 
				@GetMapping(value="/CorreosSpam/{Spam}", produces = {MediaType.APPLICATION_JSON_VALUE})
				public List<Correo> getSpam(@PathVariable(name="Spam") Boolean Spam){
					List<Correo> correo = correoService.findBySpam(Spam);
					return correo;
				}
				
	//BUSCAR CORREOS ElIMINADOS
				@GetMapping(value="/CorreosEliminados/{eliminado}", produces = {MediaType.APPLICATION_JSON_VALUE})
				public List<Correo> getEliminado(@PathVariable(name="eliminado") Boolean eliminado){
					List<Correo> correo = correoService.findByEliminado(eliminado);
					return correo;
				}
				
	//BUSCAR CORREOS DESTACADOS
				@GetMapping(value="/CorreosDestacados/{destacado}", produces = {MediaType.APPLICATION_JSON_VALUE})
				public List<Correo> getDestacado(@PathVariable(name="destacado") Boolean destacado){
					List<Correo> correo = correoService.findByDestacado(destacado);
					return correo;
				}
				
	//GUARDAR CORREOS
				@PostMapping(value="/Correos", produces = {MediaType.APPLICATION_JSON_VALUE})
				public ResponseEntity<CorreoResponse> saveCorreo(@RequestBody Correo correo) {
					
					CorreoResponse response = correoService.save(correo);
					
					if(response.getCodigoRespuesta() == 0)
						return ResponseEntity.status(HttpStatus.CREATED).body(response);
					else
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		

				}
				
				
				@PutMapping(value="/Correos", produces = {MediaType.APPLICATION_JSON_VALUE})
				public ResponseEntity<CorreoResponse> updatePedido(@RequestBody Correo correo) {
					
					CorreoResponse response = correoService.update(correo);
					
					if(response.getCodigoRespuesta() == 0)
						return ResponseEntity.status(HttpStatus.CREATED).body(response);
					else
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);		

					
				}
				
				
				
				
		
}
