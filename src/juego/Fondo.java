package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fondo {
	private double posicionX;
	private double posicionY;
	private Image img;
	private double angulo;
	
	public Fondo(int posicionX, int posicionY, String imagen) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.angulo = 0;
		this.img = Herramientas.cargarImagen(imagen);
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img, this.posicionX, this.posicionY, this.angulo, 1);
	}
}
