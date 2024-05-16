package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fondo {
	private Coordenada coordenadas;
	private Image img;
	private double angulo;
	
	public Fondo(int posicionX, int posicionY, String imagen) {
		this.coordenadas = new Coordenada(posicionX, posicionY);
		this.angulo = 0;
		this.img = Herramientas.cargarImagen(imagen);
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, this.coordenadas.getX(), this.coordenadas.getY(), this.angulo, 1);
	}
}
