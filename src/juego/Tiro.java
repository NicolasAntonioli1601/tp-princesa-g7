package juego;

import java.awt.Image;
import java.util.List;
import entorno.Entorno;
import entorno.Herramientas;

public class Tiro {
	int x;
	int y;
	Image imgTiro;
	Entorno entorno;
	int velocidad;
	boolean posicion;

	public Tiro(int x, int y, boolean posicion) {
		this.x = x;
		this.y = y;
		this.imgTiro = Herramientas.cargarImagen("recursos/tiro.png");
		this.velocidad = 10;
		this.posicion=posicion;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imgTiro, this.x, this.y, 0, 0.05);
	}

	public void moverse() {
		if (posicion== true) {
			this.x += this.velocidad;	
		}
		else {
			this.x -= this.velocidad;
		}
		
	}

	public boolean estaEnLimite() {
		return this.x <= 799 && this.x >= 0;

	}

}