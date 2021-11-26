package com.challenge.arturoisidro.RockPaperScissorsGame.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.Jugador;
import com.challenge.arturoisidro.RockPaperScissorsGame.model.Prueba;
import com.challenge.arturoisidro.RockPaperScissorsGame.model.Resultado;
import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	
	private final String ROCK_OPTION = "1";
	private int counter_random = 0;
	private int counter_rock = 0;
	private int numberGames = 0;
	private int victoriasPrimerJugador = 1;
	private int victoriasSegundoJugador = 1;
	private int numperoEmpates = 1;
	/*
	 * Habran dos tipos de jugador uno que siempre es aleatorio y el otro que
	 * siempre saca piedra
	 */

	/*
	 * Si has presionado random (0) o si has presionado (Rock)
	 */
//	@Override  este es el bueno
//	public Resultado startGame(String opcionElegida) {
//		Resultado resultado = null;
//		String shakingHand;
//		if (ROCK_OPTION.equals(opcionElegida)) {  //1 Cuando elige el radio de solo piedra
//			// Esta es la opcion s iempre piedra
//			resultado = new Resultado();
//			int jugadaPC = randomPlay(); // piedra - papel - tijera 
//		//	shakingHand = shakingHand(Integer.parseInt(ROCK_OPTION), jugadaPC);
//			Prueba shakingHandDetails = shakingHandDetails(Integer.parseInt(ROCK_OPTION), jugadaPC);
//			Jugador uno = new Jugador();
//			uno.setEleccion(numberMapper(Integer.parseInt(opcionElegida)));
//			Jugador dos = new Jugador();
//			dos.setEleccion(numberMapper(jugadaPC));
//			resultado.setYou_choose(uno);		
//			resultado.setPc_choose(dos);
//			resultado.setResultado(shakingHand(Integer.parseInt(ROCK_OPTION), jugadaPC));			
//			counter_rock++;
//			//numberGames ++;
//			return resultado;
//		} else {							//1,2,3
//			// Esta es la opcion random // ahora que jueguen entre ellos
//			resultado = new Resultado();
//			int elecionJugadorRandom = randomPlay();
//			int jugadaPC = pcPlay();		
//			Prueba shakingHandDetails = 	shakingHandDetails(elecionJugadorRandom, jugadaPC);
//			Jugador uno = new Jugador();
//			uno.setEleccion(numberMapper(elecionJugadorRandom));
//			Jugador dos = new Jugador();
//			dos.setEleccion(numberMapper(jugadaPC));
//			resultado.setYou_choose(uno);
//			resultado.setPc_choose(dos);
//			resultado.setResultado(shakingHand(elecionJugadorRandom, jugadaPC)); 
//			counter_random++;			
//			return resultado;
//		}
//	}
	
	@Override
	public Resultado startGame(String opcionElegida) {
		Resultado resultado = null;
		String shakingHand;
		if (ROCK_OPTION.equals(opcionElegida)) {  //1 Cuando elige el radio de solo piedra
			// Esta es la opcion s iempre piedra
			resultado = new Resultado();
			int jugadaPC = randomPlay(); // piedra - papel - tijera 
		//	shakingHand = shakingHand(Integer.parseInt(ROCK_OPTION), jugadaPC);
			Prueba shakingHandDetails = shakingHandDetails(Integer.parseInt(ROCK_OPTION), jugadaPC);
			Jugador uno = new Jugador();
			uno.setEleccion(numberMapper(Integer.parseInt(opcionElegida)));
			Jugador dos = new Jugador();
			dos.setEleccion(numberMapper(jugadaPC));
			resultado.setYou_choose(uno);		
			resultado.setPc_choose(dos);
			resultado.setResultado(shakingHand(Integer.parseInt(ROCK_OPTION), jugadaPC));			
			counter_rock++;
			//numberGames ++;
			return resultado;
		} else {							//1,2,3
			// Esta es la opcion random // ahora que jueguen entre ellos
			resultado = new Resultado();
			int elecionJugadorRandom = randomPlay();
			int jugadaPC = pcPlay();		
			Prueba shakingHandDetails = 	shakingHandDetails(elecionJugadorRandom, jugadaPC);
			Jugador uno = new Jugador();
			uno.setEleccion(numberMapper(elecionJugadorRandom));
			Jugador dos = new Jugador();
			dos.setEleccion(numberMapper(jugadaPC));
			resultado.setYou_choose(uno);
			resultado.setPc_choose(dos);
			resultado.setResultado(shakingHand(elecionJugadorRandom, jugadaPC)); 
			counter_random++;			
			return resultado;
		}
	}


	@Override
	public void resetGame() {		
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

		switch (pcNumber) // 1- piedra , 2papel, 3tijera
		{
		case 1: // si pc elige piedra
			System.out.println("Piedra");
			switch (numerChoose) // 1,2,3
			{
			case 1:
				System.out.println("Empate!");
				mensaje = "Draw";

				break;
			case 2:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";

				break;
			case 3:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";

				break;
			}
			break;

		case 2: //// si pc elige papel
			System.out.println("Papel");
			switch (numerChoose) {
			case 1:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";

				break;
			case 2:
				System.out.println("Empate!");
				mensaje = "Draw";

				break;
			case 3:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";

				break;
			}
			break;

		case 3: // si pc elige tijera
			System.out.println("Tijera");
			switch (numerChoose) {
			case 1:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				break;
			case 2:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				break;
			case 3:
				System.out.println("Empate!");
				mensaje = "Draw";
				break;
			}
		}
		return mensaje;
	}

	private Prueba shakingHandDetails(final int numerChoose, final int pcNumber) {
		Prueba prueba = new Prueba();
		String mensaje = "";
	
		switch (pcNumber) // 1- piedra , 2papel, 3tijera
		{
		case 1: // si pc elige piedra
			System.out.println("Piedra");			
			prueba.setElecionPlayerSecond(numberMapper(pcNumber));
			switch (numerChoose) // 1,2,3
			{
			case 1:
				System.out.println("Empate!");
				mensaje = "Draw";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_draw(numperoEmpates);
				prueba.setResultadoJuego(mensaje);
				numperoEmpates++;
				numberGames++;
				break;
			case 2:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_winPlayerFirst(victoriasPrimerJugador);
				prueba.setResultadoJuego(mensaje);

				victoriasPrimerJugador++;
				numberGames++;
				break;
			case 3:
	
				//FIXME revisa el set
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				prueba.setElecionPlayerFirst(numberMapper(pcNumber));
				prueba.setTotal_winPlayerSecond(victoriasSegundoJugador);
				prueba.setResultadoJuego(mensaje);
				victoriasSegundoJugador++;
				numberGames++;
				break;
			}
			break;

		case 2: //// si pc elige papel
			System.out.println("Papel");
			prueba.setElecionPlayerSecond(numberMapper(pcNumber));

			switch (numerChoose) {
			case 1:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_winPlayerSecond(victoriasSegundoJugador);
				prueba.setResultadoJuego(mensaje);

				victoriasSegundoJugador++;
				numberGames++;
				break;
			case 2:
				System.out.println("Empate!");
				mensaje = "Draw";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_draw(numperoEmpates);
				prueba.setResultadoJuego(mensaje);

				numperoEmpates++;
				numberGames++;
				break;
			case 3:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_winPlayerFirst(victoriasPrimerJugador);
				prueba.setResultadoJuego(mensaje);

				victoriasPrimerJugador++;
				numberGames++;
				break;
			}
			break;

		case 3: // si pc elige tijera
			System.out.println("Tijera");
			prueba.setElecionPlayerSecond(numberMapper(pcNumber));
			switch (numerChoose) {
			case 1:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_winPlayerFirst(victoriasPrimerJugador);
				prueba.setResultadoJuego(mensaje);

				victoriasPrimerJugador++;
				numberGames++;
				break;
			case 2:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_winPlayerSecond(victoriasSegundoJugador);
				prueba.setResultadoJuego(mensaje);

				victoriasSegundoJugador++;
				numberGames++;
				break;
			case 3:
				System.out.println("Empate!");
				mensaje = "Draw";
				prueba.setElecionPlayerFirst(numberMapper(numerChoose));
				prueba.setTotal_draw(numperoEmpates);
				prueba.setResultadoJuego(mensaje);

				numperoEmpates++;
				numberGames++;
				break;
			}
		}
		return prueba;
	}
	
	
	
	@Override
	public int counterRockGames() {
		return counter_rock;
	}

	@Override
	public int counterRandomGames() {
		return counter_random;
	}
	
	
	/**
	 * Method that change the my number election to texto to understand easily
	 * @param selection
	 * @return
	 */
	private String numberMapper(final int selection) {
		String electionText = "";
		switch(selection) {
		case 1:
			electionText = "ROCK";
			break;
		case 2:
			electionText = "PAPER";
			break;
		case 3:
			electionText = "SCISSORS";
			break;
		}
		return electionText;
	}

	@Override
	public int totalGames() {		
		return numberGames;
	}

}
