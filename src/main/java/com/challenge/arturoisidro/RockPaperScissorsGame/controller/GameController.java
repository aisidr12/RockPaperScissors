package com.challenge.arturoisidro.RockPaperScissorsGame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.Resultado;
import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("RockPaperScissors")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/jugar/{opcion}")
	@ApiOperation(value = "Starting the game 0- Random : 1-  Rock options", notes = "show information about the gameplay choosing and option")
	public ResponseEntity<Resultado> realizarJugada(@PathVariable("opcion") String opcionElegida) {
		Resultado startGame = gameService.startGame(opcionElegida);
		if (startGame != null) {
			return ResponseEntity.ok(startGame);
		}
		return (ResponseEntity<Resultado>) ResponseEntity.badRequest();
	}

	@PostMapping("/reset")
	@ApiOperation(value = "Restart the game ", notes = "restart the game")
	public ResponseEntity<String> reset() {
		gameService.resetGame();
		return ResponseEntity.ok().build();
	}

	@GetMapping("/jugadas")
	@ApiOperation(value = "Show number of games played ", notes = "Show number of games played")
	public ResponseEntity<Integer> cargarNumeroJugadas() {
		return ResponseEntity.ok().body(gameService.counterRandomGames() + gameService.counterRockGames());
	}

	@GetMapping("/resultados")
	@ApiOperation(value = "Show results of the game ", notes = "Show number of games played")
	public String cargarResultados() {

		return "n jugadas";
	}

	@GetMapping("/puntosRock")
	@ApiOperation(value = "Show number of Rock points ", notes = "Show rock points")
	public ResponseEntity<Integer> cargarPuntosRock() {
		return ResponseEntity.ok().body(gameService.counterRockGames());
	}

	@GetMapping("/puntosRandom")
	@ApiOperation(value = "Show number of Random points ", notes = "Show number of Random points")
	public ResponseEntity<Integer> cargarPuntosRandom() {
		return ResponseEntity.ok().body(gameService.counterRandomGames());
	}
}
