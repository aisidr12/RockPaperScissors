package com.challenge.arturoisidro.RockPaperScissorsGame.service;

import java.util.List;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.GameResult;

public interface GameService {
	/**
	 * Start the game playing with a user Selection
	 * @param opcionElegida Could be 0 - random  1 - rock option
	 * @return Information of the match
	 */
	GameResult startGame(String opcionElegida);
	
	/***
	 * Reset the game, counter to 0 and clear memory
	 */
	void resetGame();
	/**
	 * Generate a number to play, when 1 rock, 2paper, 3 scissors
	 * @return number with since 1 until 3
	 */
	int pcPlay();
	
	/**
	 * Counter how many rock games goes
	 * @return number of counter rock games
	 */
	int counterRockGames();
	
	/**
	 * counter how many random games goes
	 * @return number of counterrandomGames
	 */
	int counterRandomGames();
	
	/**
	 * Counter of total of games
	 * @return number of games
	 */
	int totalGames();
	
	int counterPlayerFirstWin();
	int counterPlayerSecondWin();
	int counterDraw();
	List<GameResult>getResults();

}
