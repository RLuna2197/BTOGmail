package com.bto.correo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Correo")
public class TbCorreo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdCorreo", nullable = false)
	private Integer IdCorreo;
	
	@Column(name="NombreEmisor", nullable = false)
	private String NombreEmisor;
	
	@Column(name="CorreoEmisor", nullable = false)
	private String CorreoEmisor;
	
	@Column(name="Fecha", nullable = false)
	private Date Fecha;
	
	@Column(name="Asunto", nullable = false)
	private String Asunto;
	
	@Column(name="Mensaje", nullable = false)
	private String Mensaje;
	
	@Column(name="Categoria", nullable = false)
	private Boolean Categoria;
	
	@Column(name="Leido", nullable = false)
	private Boolean Leido;
	
	@Column(name="Destacado", nullable = false)
	private Boolean Destacado;
	
	@Column(name="Eliminado", nullable = false)
	private Boolean Eliminado;
	
	@Column(name="Spam", nullable = false)
	private Boolean Spam;
	
	@Column(name="CorreoReceptor", nullable = false)
	private String CorreoReceptor;

	public TbCorreo() {
		super();
	}

	public TbCorreo(Integer idCorreo, String nombreEmisor, String correoEmisor, Date fecha, String asunto,
			String mensaje, Boolean categoria, Boolean leido, Boolean destacado, Boolean eliminado, Boolean spam,
			String correoReceptor) {
		super();
		this.IdCorreo = idCorreo;
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
	
	
	public TbCorreo(String nombreEmisor, String correoEmisor, Date fecha, String asunto, String mensaje,
			Boolean categoria, Boolean leido, Boolean destacado, Boolean eliminado, Boolean spam,
			String correoReceptor) {
		super();
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
		return IdCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		IdCorreo = idCorreo;
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
