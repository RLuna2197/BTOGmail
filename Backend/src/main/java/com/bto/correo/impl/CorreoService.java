package com.bto.correo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bto.correo.dto.Correo;
import com.bto.correo.dto.CorreoResponse;
import com.bto.correo.entity.TbCorreo;
import com.bto.correo.interfaz.ICorreoService;
import com.bto.correo.repository.ICorreoRepository;


@Service
public class CorreoService implements ICorreoService {

	@Autowired
	private ICorreoRepository correoRepository;
	
	@Override	
	public List<Correo> findAll() {

		List<TbCorreo> lista = correoRepository.findAll(); // SELECT * FROM Correo
		List<Correo> listadocorreos = entityListToDtoList(lista);

		return listadocorreos;
	}
	
	private List<Correo> entityListToDtoList(List<TbCorreo> lista) {
		List<Correo> listadocorreos = new ArrayList<>();
		
		for(TbCorreo ent: lista) {
			Correo correo = new Correo(ent.getIdCorreo(),
									   ent.getNombreEmisor(),
									   ent.getCorreoEmisor(), 
									   ent.getFecha(),
									   ent.getAsunto(),
									   ent.getMensaje(),
									   ent.getCategoria(),
									   ent.getLeido(),
									   ent.getDestacado(),
									   ent.getEliminado(), 
									   ent.getSpam(), 
									   ent.getCorreoReceptor());
			listadocorreos.add(correo);
		}
		return listadocorreos;
	}

	@Override
	public List<Correo> findByRecibidos(Boolean Categoria) {
		List<TbCorreo> lista = correoRepository.findAll();
		List<Correo> correoRecibidos = entityListState(Categoria, lista);
		return correoRecibidos;
		
	}
	
	private List<Correo> entityListState(Boolean categoria, List<TbCorreo> lista) {
		List<Correo> listadoCorreos =  new ArrayList<>();
		
		for(TbCorreo ent: lista) {
			Correo correo = new Correo(ent.getIdCorreo(),
									   ent.getNombreEmisor(),
									   ent.getCorreoEmisor(), 
									   ent.getFecha(),
									   ent.getAsunto(),
									   ent.getMensaje(),
									   ent.getCategoria(),
									   ent.getLeido(),
									   ent.getDestacado(),
									   ent.getEliminado(), 
									   ent.getSpam(), 
									   ent.getCorreoReceptor());
			
			if(correo.getCategoria().equals(categoria) && correo.getEliminado().equals(false) && correo.getSpam().equals(false)) {
				listadoCorreos.add(correo);
			}
		}
		
		return listadoCorreos;
	}

	@Override
	public List<Correo> findByEnviados(Boolean Categoria) {
		
		return null;
		
	}
	
	@Override
	public List<Correo> findBySpam(Boolean Spam) {
		List<TbCorreo> lista = correoRepository.findAll();
		List<Correo> correoRecibidos = entityListState2(Spam, lista);
		return correoRecibidos;
		
	}
	
	private List<Correo> entityListState2(Boolean spam, List<TbCorreo> lista) {
		List<Correo> listadoCorreos =  new ArrayList<>();
		
		for(TbCorreo ent: lista) {
			Correo correo = new Correo(ent.getIdCorreo(),
									   ent.getNombreEmisor(),
									   ent.getCorreoEmisor(), 
									   ent.getFecha(),
									   ent.getAsunto(),
									   ent.getMensaje(),
									   ent.getCategoria(),
									   ent.getLeido(),
									   ent.getDestacado(),
									   ent.getEliminado(), 
									   ent.getSpam(), 
									   ent.getCorreoReceptor());
			
			if(correo.getSpam().equals(spam) && correo.getCategoria().equals(false)) {
				listadoCorreos.add(correo);
			}
		}
		return listadoCorreos;
	}

	@Override
	public List<Correo> findByEliminado(Boolean Eliminado) {
		List<TbCorreo> lista = correoRepository.findAll();
		List<Correo> correoRecibidos = entityListState3(Eliminado, lista);
		return correoRecibidos;
		
	}

	private List<Correo> entityListState3(Boolean eliminado, List<TbCorreo> lista) {
List<Correo> listadoCorreos =  new ArrayList<>();
		
		for(TbCorreo ent: lista) {
			Correo correo = new Correo(ent.getIdCorreo(),
									   ent.getNombreEmisor(),
									   ent.getCorreoEmisor(), 
									   ent.getFecha(),
									   ent.getAsunto(),
									   ent.getMensaje(),
									   ent.getCategoria(),
									   ent.getLeido(),
									   ent.getDestacado(),
									   ent.getEliminado(), 
									   ent.getSpam(), 
									   ent.getCorreoReceptor());
			
			if(correo.getEliminado().equals(eliminado)) {
				listadoCorreos.add(correo);
			}
		}
		return listadoCorreos;
	}
	
	@Override
	public List<Correo> findByDestacado(Boolean Destacado) {
		List<TbCorreo> lista = correoRepository.findAll();
		List<Correo> correoRecibidos = entityListState4(Destacado, lista);
		return correoRecibidos;
		
	}
	
	private List<Correo> entityListState4(Boolean destacado, List<TbCorreo> lista) {
		List<Correo> listadoCorreos =  new ArrayList<>();
		
		for(TbCorreo ent: lista) {
			Correo correo = new Correo(ent.getIdCorreo(),
									   ent.getNombreEmisor(),
									   ent.getCorreoEmisor(), 
									   ent.getFecha(),
									   ent.getAsunto(),
									   ent.getMensaje(),
									   ent.getCategoria(),
									   ent.getLeido(),
									   ent.getDestacado(),
									   ent.getEliminado(), 
									   ent.getSpam(), 
									   ent.getCorreoReceptor());
			
			if(correo.getDestacado().equals(destacado)) {
				listadoCorreos.add(correo);
			}
		}
		return listadoCorreos;
	}

	@Override
	public CorreoResponse save(Correo correo) {
		
		return guardarCorreo(correo);
	}

	private CorreoResponse guardarCorreo(Correo dto) {
		CorreoResponse response = new CorreoResponse();
		
		TbCorreo correo = new TbCorreo(
				   dto.getNombreEmisor(),
				   dto.getCorreoEmisor(), 
				   dto.getFecha(),
				   dto.getAsunto(),
				   dto.getMensaje(),
				   dto.getCategoria(),
				   dto.getLeido(),
				   dto.getDestacado(),
				   dto.getEliminado(), 
				   dto.getSpam(), 
				   dto.getCorreoReceptor());
		
		correo = correoRepository.save(correo);
		response.setCodigoRespuesta(0);
		response.setMensajeRespuesta("Se agrego Correctamente");
		return response;
	}
	
	@Override
	public Correo findById(Integer IdCorreo) {
//		Correo result = new Correo();
//
//		Optional<TbCorreo> correo = correoRepository.findById(IdCorreo);
//
//		if (correo.isPresent()) {
//			result = entityToDto(correo.get());
//		}

		return null;
	}
	/*
	 * public Correo entityToDto(TbCorreo ent) { Correo correo = new
	 * Correo(ent.getIdCorreo(), ent.getLeido(), ent.getDestacado(), ent.getSpam(),
	 * ent.getEliminado());
	 * 
	 * 
	 * return correo; }
	 */
	
	/**
	 *
	 */
	@Override
	public CorreoResponse update(Correo correo) {
		
		
		  CorreoResponse response = new CorreoResponse(); 
		  Optional<TbCorreo> ent = correoRepository.findById(correo.getIdCorreo());
		  
		  if(ent.isPresent()) { 
			  TbCorreo enti = ent.get();
		  enti.setLeido(correo.getLeido());
		  enti.setDestacado(correo.getDestacado()); 
		  enti.setSpam(correo.getSpam());
		  enti.setEliminado(correo.getEliminado()); 
		  correoRepository.save(enti);
		  response.setCodigoRespuesta(0); response.setMensajeRespuesta("El Correo No."+enti.getIdCorreo() + " se actualizo"); }
		  
		  else {
		  response.setCodigoRespuesta(1);
		  response.setMensajeRespuesta("El correo no existe"); }
	 
	 
	return response;
	}

	

	
	
	
	
}
