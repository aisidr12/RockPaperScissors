package com.challenge.arturoisidro.RockPaperScissorsGame.servicesimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.GameResult;

class GameServiceImplTest {
	private final  String ROCK = "ROCK";
	private final  String PAPER = "PAPER";
	private final  String SCISSOR = "SCISSOR";
	private final  String DRAW = "DRAW";	
	private GameServiceImpl service = new GameServiceImpl();
	
	@Test
	void selecctionPlayerOneRandom() {
		String randomSelection = "0";
		GameResult startGame = service.startGame(randomSelection);
		assertEquals(1,service.counterRandomGames());	
	}
	@Test
	void selecctionRockGame() {
		String randomSelection = "1";
		GameResult startGame = service.startGame(randomSelection);
		assertEquals(1,service.counterRockGames());	
	}
	
	@Test
	void selecctionPlayerTwoRock() {
		String rockSelection = "1";
		GameResult startGame = service.startGame(rockSelection);
		assertEquals("ROCK",startGame.getElecionPlayerFirst());
		assertEquals(1, service.counterRockGames());
	}
	
	@Test
	void shakingHandDrawRock() {
		final int rockSelectionByUser = 1;
		final int rockSelectionByPC = 1;
		GameResult gameResult = service.shakingHandDetails(rockSelectionByUser, rockSelectionByPC);
		assertEquals(DRAW, gameResult.getResultadoJuego());
		assertEquals(ROCK, gameResult.getElecionPlayerFirst());
		assertEquals(ROCK, gameResult.getElecionPlayerSecond());
		assertEquals(1, gameResult.getDraw());		
	}
	
	@Test
	void shakingHandPlayerTwoWin() {
		final int selectionByUserRock = 1;
		final int selectionByPCPaper = 2;
		GameResult gameResult = service.shakingHandDetails(selectionByUserRock, selectionByPCPaper);
		assertEquals(ROCK, gameResult.getElecionPlayerFirst());
		assertEquals(PAPER, gameResult.getElecionPlayerSecond());
		assertEquals(1, gameResult.getWinPlayerSecond());		
	}
	
	@Test
	void shakingHandPlayerOneWin() {
		final int selectionByUserRock = 1;
		final int selectionByPcCsissor = 3;
		GameResult gameResult = service.shakingHandDetails(selectionByUserRock, selectionByPcCsissor);
		assertEquals(ROCK, gameResult.getElecionPlayerFirst());
		assertEquals(SCISSOR, gameResult.getElecionPlayerSecond());
		assertEquals(1, gameResult.getWinPlayerFirst());	
	}
	
	

	
	
		

}
