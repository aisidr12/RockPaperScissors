package com.challenge.arturoisidro.RockPaperScissorsGame.service;

public interface GameService {
	
	String realizarJugada(String opcionElegida);
	void resetJugada();
	int pcJuegada();

}
