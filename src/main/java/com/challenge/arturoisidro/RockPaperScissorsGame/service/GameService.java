package com.challenge.arturoisidro.RockPaperScissorsGame.service;

public interface GameService {
	
	String startGame(String opcionElegida);
	void resetGame();
	int pcPlay();
	int counterRockGames();
	int counterRandomGames();

}
