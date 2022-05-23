package com.carro.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carro.service.entidades.Carro;
import com.carro.service.servicio.CarroService;


@Controller
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<Carro>> getCars(){
		List<Carro> cars = carroService.getAll();
		if(cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> getCar(@PathVariable("id") int id){
		Carro car = carroService.getUsuarioById(id);
		if(car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@PostMapping
	public ResponseEntity<Carro> saveCar(@RequestBody Carro car){
		Carro newCar = carroService.save(car);
		return ResponseEntity.ok(newCar);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
		List<Carro> carros = carroService.byUsuarioId(usuarioId);
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	

}
