package com.moto.service.respositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moto.service.entidades.Motocicleta;

@Repository
public interface MotoRespository extends JpaRepository<Motocicleta, Integer> {
	
	List<Motocicleta> findByUsuarioId(int usuarioId);
}
