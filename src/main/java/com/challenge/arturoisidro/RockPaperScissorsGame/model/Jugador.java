package com.challenge.arturoisidro.RockPaperScissorsGame.model;

public class Jugador {

	private String  nombre;
	private String  eleccion;
	private String 	resultado;
	public Jugador(String nombre, String eleccion, String resultado) {
		super();
		this.nombre = nombre;
		this.eleccion = eleccion;
		this.resultado = resultado;
	}
	public Jugador() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEleccion() {
		return eleccion;
	}
	public void setEleccion(String eleccion) {
		this.eleccion = eleccion;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
