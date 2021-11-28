package com.challenge.arturoisidro.RockPaperScissorsGame.Exception;

public class OptionNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje ;
	
	public OptionNotFoundException(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
