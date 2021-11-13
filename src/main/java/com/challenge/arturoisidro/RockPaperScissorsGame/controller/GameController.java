package com.challenge.arturoisidro.RockPaperScissorsGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@RestController
@RequestMapping("RockPaperScissors")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	
	@PostMapping("/jugar")
	public ResponseEntity<String>realizarJugada(){
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/reset")
	public ResponseEntity<String>reset(){
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/jugadas")
	public String cargarNumeroJugadas() {
		return "n jugadas";
	}
	
	@GetMapping("/resultados")
	public String cargarResultados() {
		return "n jugadas";
	}
}
	