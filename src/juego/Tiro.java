package juego;

import java.awt.Image;
import java.util.List;
import entorno.Entorno;
import entorno.Herramientas;

public class Tiro {
	int x;
	int y;
	int velocidad;
	boolean posicion;
	Image imgTiro;
	Entorno entorno;

	public Tiro(int x, int y, boolean posicion) {
		this.x = x;
		this.y = y;
		this.imgTiro = Herramientas.cargarImagen("recursos/disparoIzq.png");
		this.velocidad = 10;
		this.posicion=posicion;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imgTiro, this.x, this.y, 0, 0.2);
	}

	public void moverse() {
		if (posicion== true) {
			this.x += this.velocidad;	
			this.imgTiro=Herramientas.cargarImagen("recursos/disparoDer.png");
		}
		else {
			this.x -= this.velocidad;
			this.imgTiro=Herramientas.cargarImagen("recursos/disparoIzq.png");
		}
		
	}

	public boolean estaEnLimite() {
		return this.x <= 799 && this.x >= 0;

	}

}