package com.challenge.arturoisidro.RockPaperScissorsGame.model;

public class ResultadoInfoDetail {

	private Resultado resultado;
	private int totalWinFirstPlayers;
	private int totalWinSecondPlayers;
	private int totalDraw;
	public Resultado getResultado() {
		return resultado;
	}
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	public int getTotalWinFirstPlayers() {
		return totalWinFirstPlayers;
	}
	public void setTotalWinFirstPlayers(int totalWinFirstPlayers) {
		this.totalWinFirstPlayers = totalWinFirstPlayers;
	}
	public int getTotalWinSecondPlayers() {
		return totalWinSecondPlayers;
	}
	public void setTotalWinSecondPlayers(int totalWinSecondPlayers) {
		this.totalWinSecondPlayers = totalWinSecondPlayers;
	}
	public int getTotalDraw() {
		return totalDraw;
	}
	public void setTotalDraw(int totalDraw) {
		this.totalDraw = totalDraw;
	}
	
}
