package com.bto.correo.dto;

import java.util.Date;

public class Correo {
	private Integer idCorreo;
	private String NombreEmisor;
	private String CorreoEmisor;
	private Date Fecha;
	private String Asunto;
	private String Mensaje;
	private Boolean Categoria;
	private Boolean Leido;
	private Boolean Destacado;
	private Boolean Eliminado;
	private Boolean Spam;
	private String CorreoReceptor;
	
	

	public Correo() {
		super();
	}



	public Correo(Integer idCorreo, String nombreEmisor, String correoEmisor, Date fecha, String asunto, String mensaje,
			Boolean categoria, Boolean leido, Boolean destacado, Boolean eliminado, Boolean spam,
			String correoReceptor) {
		super();
		this.idCorreo = idCorreo;
		NombreEmisor = nombreEmisor;
		CorreoEmisor = correoEmisor;
		Fecha = fecha;
		Asunto = asunto;
		Mensaje = mensaje;
		Categoria = categoria;
		Leido = leido;
		Destacado = destacado;
		Eliminado = eliminado;
		Spam = spam;
		CorreoReceptor = correoReceptor;
	}
	

	public Integer getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getNombreEmisor() {
		return NombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		NombreEmisor = nombreEmisor;
	}

	public String getCorreoEmisor() {
		return CorreoEmisor;
	}

	public void setCorreoEmisor(String correoEmisor) {
		CorreoEmisor = correoEmisor;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String asunto) {
		Asunto = asunto;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public Boolean getCategoria() {
		return Categoria;
	}

	public void setCategoria(Boolean categoria) {
		Categoria = categoria;
	}

	public Boolean getLeido() {
		return Leido;
	}

	public void setLeido(Boolean leido) {
		Leido = leido;
	}

	public Boolean getDestacado() {
		return Destacado;
	}

	public void setDestacado(Boolean destacado) {
		Destacado = destacado;
	}

	public Boolean getEliminado() {
		return Eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		Eliminado = eliminado;
	}

	public Boolean getSpam() {
		return Spam;
	}

	public void setSpam(Boolean spam) {
		Spam = spam;
	}

	public String getCorreoReceptor() {
		return CorreoReceptor;
	}

	public void setCorreoReceptor(String correoReceptor) {
		CorreoReceptor = correoReceptor;
	}
	
	
	
}
