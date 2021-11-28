package com.challenge.arturoisidro.RockPaperScissorsGame.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.challenge.arturoisidro.RockPaperScissorsGame.model.GameResult;
import com.challenge.arturoisidro.RockPaperScissorsGame.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	Log log = LogFactory.getLog(GameServiceImpl.class);
	private List<GameResult> gameSession = new ArrayList<GameResult>();
	private final String ROCK_OPTION = "1";
	private int counter_random = 0;
	private int counter_rock = 0;
	private int victoriasPrimerJugador = 1;
	private int victoriasSegundoJugador = 1;
	private int numperoEmpates = 1;
	private final  String ROCK = "ROCK";
	private final  String PAPER = "PAPER";
	private final  String SCISSOR = "SCISSOR";
	private final  String DRAW = "DRAW";


	
	@Override
	public GameResult startGame(String opcionElegida) {
		log.info("Empezando el juego con la eleccion elegida " + opcionElegida);
		if (ROCK_OPTION.equals(opcionElegida)) {  //1 Cuando elige el radio de solo piedra
			log.info("Dentro de la opcion Siempre piedra");			
			int jugadaPC = randomPlay(); // piedra - papel - tijera 
			GameResult shakingHandDetails = shakingHandDetails(Integer.parseInt(ROCK_OPTION), jugadaPC);
			gameSession.add(shakingHandDetails);
			counter_rock++;
			return shakingHandDetails;
		} else {		
			log.info("Dentro de la opción siempre random");
			int elecionJugadorRandom = randomPlay();
			log.info("La eleccion del random es: "+ elecionJugadorRandom);
			int jugadaPC = pcPlay();
			log.info("La eleccion del pc es: "+ jugadaPC);
			GameResult shakingHandDetails = shakingHandDetails(elecionJugadorRandom, jugadaPC);
			gameSession.add(shakingHandDetails);
			counter_random++;
			return shakingHandDetails;
		}
	}


	@Override
	public void resetGame() {	
		gameSession.clear();
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

	protected GameResult shakingHandDetails(final int numerChoose, final int pcNumber) {
		GameResult gameResultado = new GameResult();
		String mensaje = "";
	
		switch (pcNumber) // 1- piedra , 2papel, 3tijera
		{
		case 1: // si pc elige piedra
			log.info("Dentro de la eleccion de la PC: " + numberMapper(pcNumber));		
			gameResultado.setElecionPlayerSecond(numberMapper(pcNumber));
			switch (numerChoose) // 1,2,3
			{
			case 1:
			log.info("DRAW");
				mensaje = DRAW;
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setDraw(numperoEmpates);
				gameResultado.setResultadoJuego(mensaje);
		
				break;
			case 2:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerFirst(victoriasPrimerJugador);
				gameResultado.setResultadoJuego(mensaje);

				break;
			case 3:			 
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerSecond(victoriasSegundoJugador);
				gameResultado.setResultadoJuego(mensaje);			
				break;
			}
			break;

		case 2: //// si pc elige papel
			log.info("Dentro de la eleccion de la PC: " + numberMapper(pcNumber));		

		
			gameResultado.setElecionPlayerSecond(numberMapper(pcNumber));

			switch (numerChoose) {
			case 1:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerSecond(victoriasSegundoJugador);
				gameResultado.setResultadoJuego(mensaje);

			
				break;
			case 2:
				System.out.println("Empate!");
				mensaje = DRAW;
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setDraw(numperoEmpates);
				gameResultado.setResultadoJuego(mensaje);

			
				break;
			case 3:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerFirst(victoriasPrimerJugador);
				gameResultado.setResultadoJuego(mensaje);

				break;
			}
			break;

		case 3: // si pc elige tijera
		
			log.info("Dentro de la eleccion de la PC :" + numberMapper(pcNumber));
			gameResultado.setElecionPlayerSecond(numberMapper(pcNumber));
			switch (numerChoose) {
			case 1:
				System.out.println("Usted gana!");
				mensaje = "Player 1 wins";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerFirst(victoriasPrimerJugador);
				gameResultado.setResultadoJuego(mensaje);

				break;
			case 2:
				System.out.println("La computadora gana!");
				mensaje = "Player 2 wins (PC)";
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setWinPlayerSecond(victoriasSegundoJugador);
				gameResultado.setResultadoJuego(mensaje);

				break;
			case 3:
				System.out.println("Empate!");
				mensaje = DRAW;
				gameResultado.setElecionPlayerFirst(numberMapper(numerChoose));
				gameResultado.setDraw(numperoEmpates);
				gameResultado.setResultadoJuego(mensaje);
				break;
			}
		}
		return gameResultado;
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
			electionText = ROCK;
			break;
		case 2:
			electionText = PAPER;
			break;
		case 3:
			electionText = SCISSOR;
			break;
		}
		return electionText;
	}

	@Override
	public int totalGames() {		
		return gameSession.size();
	}


	@Override
	public int counterPlayerFirstWin() {
		int counterPlayerOneWin = 0;
		for (GameResult gameResult : gameSession) {
			counterPlayerOneWin = counterPlayerOneWin + gameResult.getWinPlayerFirst() ;			
		}
		return counterPlayerOneWin;
	}


	@Override
	public int counterPlayerSecondWin() {
		int counterPlayerSecondWin = 0;
		for (GameResult gameResult : gameSession) {
			counterPlayerSecondWin = counterPlayerSecondWin + gameResult.getWinPlayerSecond() ;			
		}
		return counterPlayerSecondWin;
	}


	@Override
	public int counterDraw() {
		int counterDraw = 0;
		for (GameResult gameResult : ListUtils.emptyIfNull(gameSession)) {
			counterDraw  = counterDraw +gameResult.getDraw();
		}
		return counterDraw;
	}


	@Override
	public List<GameResult> getResults() {
	
		return gameSession;
	}

}
