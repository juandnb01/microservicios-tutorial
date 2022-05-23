package com.moto.service.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidades.Motocicleta;
import com.moto.service.respositorio.MotoRespository;

@Service
public class MotocicletaService {

	@Autowired
	private MotoRespository motoRespository;

	public List<Motocicleta> getAll() {
		return motoRespository.findAll();
	};

	public Motocicleta getUsuarioById(int id) {
		return motoRespository.findById(id).orElse(null);
	}

	public Motocicleta save(Motocicleta motocicleta) {
		Motocicleta newMoto = motoRespository.save(motocicleta);
		return newMoto;
	}

	public List<Motocicleta> byUsuarioId(int usuarioId) {
		return motoRespository.findByUsuarioId(usuarioId);
	}
}
