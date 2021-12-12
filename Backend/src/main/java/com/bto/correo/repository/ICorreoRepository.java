package com.bto.correo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.bto.correo.entity.TbCorreo;

public interface ICorreoRepository extends JpaRepository<TbCorreo, Integer> {
	
	//Void save(Optional<Correo> correoToUpdate);
	//public TbCorreo findByIdCorreo(Integer idCorreo);
	//public TbCorreo findByIdCorreo(Integer Idcorreo);
}
