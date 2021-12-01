package com.challenge.arturoisidro.RockPaperScissorsGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.arturoisidro.RockPaperScissorsGame.Exception.OptionNotFoundException;
import com.challenge.arturoisidro.RockPaperScissorsGame.model.GameResult;
import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("RockPaperScissors")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/jugar/{opcion}")
	@ApiOperation(value = "Starting the game 0- Random : 1-  Rock options", notes = "show information about the gameplay choosing and option")
	public ResponseEntity<GameResult> realizarJugada(@PathVariable("opcion") String opcionElegida) {
		GameResult startGame;
		try {
			startGame = gameService.startGame(opcionElegida);
			return ResponseEntity.ok(startGame);
		} catch (OptionNotFoundException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
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
		return ResponseEntity.ok().body(gameService.totalGames());
	}

	@GetMapping("/resultados")
	@ApiOperation(value = "Show results of the game ", notes = "Show number of games played")
	public ResponseEntity<List<GameResult>> cargarResultados() {

		return ResponseEntity.ok(gameService.getResults());
	}

	@GetMapping("/totalFirstPlayer")
	@ApiOperation(value = "Count the number of winners of player 1", notes = "Count the number of winners of player 2")
	public ResponseEntity<Integer> cargarPuntosRock() {
		return ResponseEntity.ok().body(gameService.counterPlayerFirstWin());
	}

	@GetMapping("/totalSecondPlayer")
	@ApiOperation(value = "Count the number of winners of player 2", notes = "Count the number of winners of player 2")
	public ResponseEntity<Integer> cargarPuntosRandom() {
		return ResponseEntity.ok().body(gameService.counterPlayerSecondWin());
	}

	@GetMapping("/totalDraw")
	@ApiOperation(value = "Show number of Random points ", notes = "Show number of Random points")
	public ResponseEntity<Integer> cargarDraw() {
		return ResponseEntity.ok().body(gameService.counterDraw());
	}
}
