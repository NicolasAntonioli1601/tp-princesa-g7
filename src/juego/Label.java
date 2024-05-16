package juego;

import java.awt.Color;

import entorno.Entorno;

public class Label {
	private Coordenada coordenadas;
	private String texto;

	public Label(int posicionX, int posicionY, String texto) {
		this.coordenadas = new Coordenada(posicionX, posicionY);
		this.texto = texto;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.escribirTexto(texto, this.coordenadas.getX(), this.coordenadas.getY());
		
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
