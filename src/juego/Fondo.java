package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fondo {
	private double x;
	private double y;
	private Image imgFondo;
	double anguloFondo;
	
	public Fondo(double x, double y) {
		this.x = x;
		this.y = y;
		imgFondo = Herramientas.cargarImagen("lollipop-jelly-candies.jpg");
		anguloFondo=0;
	}
	public void dibujarse(Entorno entorno)
	{
		entorno.dibujarImagen(imgFondo, this.x, this.y, this.anguloFondo, 0.5);
	}
	public void cambiarAngulo() {
		this.anguloFondo +=0.001;
	}
	
}
