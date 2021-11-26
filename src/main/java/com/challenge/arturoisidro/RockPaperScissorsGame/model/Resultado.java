package com.challenge.arturoisidro.RockPaperScissorsGame.model;

public class Resultado {

	private Jugador you_choose;
	private Jugador pc_choose;
	private String resultado;
	
	public Jugador getYou_choose() {
		return you_choose;
	}
	public void setYou_choose(Jugador you_choose) {
		this.you_choose = you_choose;
	}
	public Jugador getPc_choose() {
		return pc_choose;
	}
	public void setPc_choose(Jugador pc_choose) {
		this.pc_choose = pc_choose;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

	
}
