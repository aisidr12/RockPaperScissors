package com.challenge.arturoisidro.RockPaperScissorsGame.servicesimpl;

import org.springframework.stereotype.Service;

import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	
	/*
	 * Habran dos tipos de jugador
	 *  uno que siempre es aleatorio  y el otro que siempre saca piedra
	 */
	
	@Override
	public String realizarJugada(String opcionElegida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetJugada() {
		// TODO Auto-generated method stub
		
	}
	/***
	 * Jugada de la pc que puede devolver un numero random
	 * pcJugada : 1  = Piedra 
	 * pcJugada : 2  = papel
	 * pcJugada : 3  = tijera
	 */
	@Override
	public int pcJuegada() {
		int pcJugada =  (int)Math.round(Math.random()*2)+1;
		return pcJugada;
	}

}
