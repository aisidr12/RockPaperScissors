package com.challenge.arturoisidro.RockPaperScissorsGame.model;

public class GameResult {
	private String elecionPlayerFirst;
	private String elecionPlayerSecond;
	private String resultadoJuego;
	private int winPlayerFirst;
	private int winPlayerSecond;
	private int draw;
	public String getElecionPlayerFirst() {
		return elecionPlayerFirst;
	}
	public void setElecionPlayerFirst(String elecionPlayerFirst) {
		this.elecionPlayerFirst = elecionPlayerFirst;
	}
	public String getElecionPlayerSecond() {
		return elecionPlayerSecond;
	}
	public void setElecionPlayerSecond(String elecionPlayerSecond) {
		this.elecionPlayerSecond = elecionPlayerSecond;
	}
	public String getResultadoJuego() {
		return resultadoJuego;
	}
	public void setResultadoJuego(String resultadoJuego) {
		this.resultadoJuego = resultadoJuego;
	}
	public int getWinPlayerFirst() {
		return winPlayerFirst;
	}
	public void setWinPlayerFirst(int total_winPlayerFirst) {
		this.winPlayerFirst = total_winPlayerFirst;
	}
	public int getWinPlayerSecond() {
		return winPlayerSecond;
	}
	public void setWinPlayerSecond(int total_winPlayerSecond) {
		this.winPlayerSecond = total_winPlayerSecond;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int total_draw) {
		this.draw = total_draw;
	}
	@Override
	public String toString() {
		return "GameResult [elecionPlayerFirst=" + elecionPlayerFirst + ", elecionPlayerSecond=" + elecionPlayerSecond
				+ ", resultadoJuego=" + resultadoJuego + ", winPlayerFirst=" + winPlayerFirst + ", winPlayerSecond="
				+ winPlayerSecond + ", draw=" + draw + "]";
	}

	
	
	
	
}
