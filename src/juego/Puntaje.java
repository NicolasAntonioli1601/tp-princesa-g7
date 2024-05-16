package juego;

import entorno.Entorno;

public class Puntaje {
	private int puntos;
	static final int VALOR_ENEMIGO_COMUN = 3;
	private Label label;
	
	public Puntaje() {
		this.puntos = 0;
		this.label = new Label(20, 30, getPuntosAsString());
	}

	public int getPuntos() {
		return puntos;
	}
	
	public String getPuntosAsString() {
		return "Puntaje: " + Integer.toString(this.puntos);
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void matoEnemigo(){
		this.puntos += VALOR_ENEMIGO_COMUN; 
	}
	
	public void dibujarPuntaje(Entorno entorno) {
		this.label.setTexto("Puntaje: "+puntos);
		this.label.dibujar(entorno);
	}
	
	
}
