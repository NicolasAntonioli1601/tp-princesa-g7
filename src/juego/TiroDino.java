package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class TiroDino {
	private double x;
	private double y;
	double velocidad;
	boolean posicion;
	Image imgTiro;
	Entorno entorno;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// CONTRUCTOR
	public TiroDino(double x, double y, boolean posicion) {
		this.x = x;
		this.y = y;
		this.velocidad =5;
		this.posicion = posicion;
		imgTiro =Herramientas.cargarImagen("recursos/tiroDino.png");

	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imgTiro, this.x, this.y, 0, 0.7);
	}

	public void moverse() {
		if (posicion == true) {
			x += velocidad;
			this.imgTiro = Herramientas.cargarImagen("recursos/tiroDinoDer.png");
		} else {
			x -= this.velocidad;
			this.imgTiro = Herramientas.cargarImagen("recursos/tiroDino.png");
		}

	}

	public boolean estaEnLimite() {
		return this.x <= 799 && this.x >= 0;

	}

}
