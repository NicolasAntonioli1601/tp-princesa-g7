package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	Image img1;
	private double angulo;
	double posicionX;
	double posicionY;
	private Entorno entorno;

	public Princesa(int posicionX, int posicionY) {
		super();
		this.coordenadas = new Coordenada(posicionX, posicionY);
		this.img1 = Herramientas.cargarImagen("princesaJuli2-removebg-preview.png");
		this.angulo = 0;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.coordenadas.getX(), this.coordenadas.getY(), this.angulo, 0.3);
	}
	public void moverDerecha() {
		this.coordenadas.moverX(true);
	}
	public void moverIzquierda() {
		this.coordenadas.moverX(false);
	}

	}
