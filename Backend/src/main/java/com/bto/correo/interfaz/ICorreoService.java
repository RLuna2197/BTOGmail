package com.bto.correo.interfaz;

import java.util.List;


import com.bto.correo.dto.CorreoResponse;
import com.bto.correo.dto.Correo;

public interface ICorreoService {
	//
	public List<Correo> findAll();
	
	//Buscar por recibidos
	public List<Correo>  findByRecibidos(Boolean Categoria);
	
	//Buscar por enviados
	public List<Correo>  findByEnviados(Boolean Categoria);
	
	//Buscar por spam
	public List<Correo>  findBySpam(Boolean Spam);
		
	//Buscar por papelera
	public List<Correo>  findByEliminado(Boolean Eliminado);
	
	
	//Buscar Por Destacados
	public List<Correo>  findByDestacado(Boolean Destacado);
	
	//Guardar
	public CorreoResponse save(Correo correo);
	
	//Update
	//public CorreoResponse updateCorreo(Correo correoNew);
	public CorreoResponse update(Correo correo);
	
	
	
	public Correo findById(Integer IdCorreo);
	
	
}
