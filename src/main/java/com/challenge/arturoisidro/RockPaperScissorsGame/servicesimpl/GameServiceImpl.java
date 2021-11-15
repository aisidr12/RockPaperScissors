package com.challenge.arturoisidro.RockPaperScissorsGame.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.Jugador;
import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	List<Jugador> listaRandomPlayers = new ArrayList<Jugador>();
	List<Jugador> listaRockPlayers = new ArrayList<Jugador>();
	private final String ROCK_OPTION = "1";
	private int counter_random = 0;
	private int counter_rock = 0;
	/*
	 * Habran dos tipos de jugador uno que siempre es aleatorio y el otro que
	 * siempre saca piedra
	 */

	/*
	 * Si has presionado random (0) o si has presionado (Rock)
	 */
	@Override
	public String startGame(String opcionElegida) {
		Jugador player = new Jugador();

		String shakingHand;
		if (ROCK_OPTION.equals(opcionElegida)) {
			// Esta es la opcion siempre piedra
			shakingHand = shakingHand(Integer.parseInt(ROCK_OPTION), randomPlay());
			player.setEleccion(opcionElegida); // elegista piedra
			player.setResultado(shakingHand); //
			listaRandomPlayers.add(player);
			counter_rock++;
		} else {
			// Esta es la opcion random // ahora que jueguen entre ellos
			shakingHand = shakingHand(randomPlay(), pcPlay());
			player.setEleccion(opcionElegida);
			player.setResultado(shakingHand);
			listaRandomPlayers.add(player);
			counter_random++;
		}
		return shakingHand;
	}

	@Override
	public void resetGame() {
		listaRandomPlayers.clear();
		listaRockPlayers.clear();
		counter_random = 0;
		counter_rock = 0;
	}

	/***
	 * Jugada de la pc que puede devolver un numero random pcJugada : 1 = Piedra
	 * pcJugada : 2 = papel pcJugada : 3 = tijera
	 */
	@Override
	public int pcPlay() {
		int pcJugada = (int) Math.round(Math.random() * 2) + 1;
		return pcJugada;
	}

	private int randomPlay() {
		return (int) Math.round(Math.random() * 2) + 1;
	}

	/***
	 * 
	 * @param numerChoose numero de la posición
	 * @param pcNumber    numero aleatorio
	 * @return
	 */
	private String shakingHand(final int numerChoose, final int pcNumber) {
		String mensaje = "";

		switch (pcNumber) // 1- piedra , papel, tijera
		{
		case 1: // piedra
			System.out.println("Piedra");
			switch (numerChoose) // 1,2,3
			{
			case 1:
				System.out.println("Empate!");
				mensaje = "Empate";

				break;
			case 2:
				System.out.println("Usted gana!");
				mensaje = "Ud gana";

				break;
			case 3:
				System.out.println("La computadora gana!");
				mensaje = "pc gana";

				break;
			}
			break;

		case 2: // papel
			System.out.println("Papel");
			switch (numerChoose) {
			case 1:
				System.out.println("La computadora gana!");
				mensaje = "La compu gana";

				break;
			case 2:
				System.out.println("Empate!");
				mensaje = "empate";

				break;
			case 3:
				System.out.println("Usted gana!");
				mensaje = "ud gana";

				break;
			}
			break;

		case 3: // tijera
			System.out.println("Tijera");
			switch (numerChoose) {
			case 1:
				System.out.println("Usted gana!");

				mensaje = "Ud gana";
				break;
			case 2:
				System.out.println("La computadora gana!");

				mensaje = "la compu gana";
				break;
			case 3:
				System.out.println("Empate!");

				mensaje = "empate";
				break;
			}
		}
		return mensaje;
	}

	@Override
	public int counterRockGames() {
		return counter_rock;
	}

	@Override
	public int counterRandomGames() {
		return counter_random;
	}

}
