package com.moto.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moto.service.entidades.Motocicleta;
import com.moto.service.servicios.MotocicletaService;

@Controller
@RequestMapping("/moto")
public class MotocicletaController {

	@Autowired
	private MotocicletaService motocicletaService;

	@GetMapping
	public ResponseEntity<List<Motocicleta>> getCars() {
		List<Motocicleta> moto = motocicletaService.getAll();
		if (moto.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(moto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Motocicleta> getCar(@PathVariable("id") int id) {
		Motocicleta moto = motocicletaService.getUsuarioById(id);
		if (moto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}

	@PostMapping
	public ResponseEntity<Motocicleta> saveCar(@RequestBody Motocicleta car) {
		Motocicleta newMoto = motocicletaService.save(car);
		return ResponseEntity.ok(newMoto);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Motocicleta>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId) {
		List<Motocicleta> motos = motocicletaService.byUsuarioId(usuarioId);
		if (motos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}

}
