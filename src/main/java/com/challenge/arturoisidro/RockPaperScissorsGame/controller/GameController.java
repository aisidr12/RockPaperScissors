package com.challenge.arturoisidro.RockPaperScissorsGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@RestController
@RequestMapping("RockPaperScissors")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/jugar/{opcion}")
	public ResponseEntity<String> realizarJugada(@PathVariable("opcion") String opcionElegida) {
		String startGame = gameService.startGame(opcionElegida);
		if (startGame != null) {
			return ResponseEntity.ok(startGame);
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/reset")
	public ResponseEntity<String> reset() {
		gameService.resetGame();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/jugadas")
	public ResponseEntity<Integer> cargarNumeroJugadas() {
		return ResponseEntity.ok().body(gameService.counterRandomGames() + gameService.counterRockGames());
	}

	@GetMapping("/resultados")
	public String cargarResultados() {

		return "n jugadas";
	}

	@GetMapping("/puntosRock")
	public ResponseEntity<Integer> cargarPuntosRock() {
		return ResponseEntity.ok().body(gameService.counterRockGames());
	}

	@GetMapping("/puntosRandom")
	public ResponseEntity<Integer> cargarPuntosRandom() {
		return ResponseEntity.ok().body(gameService.counterRandomGames());
	}
}
