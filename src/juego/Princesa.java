package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	private Entorno entorno;
	boolean posicionDerecha;
	Image img1;
	String imagenCargada;
	

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public Princesa(int posicionX, int posicionY) {
		this.setCoordenadas(new Coordenada(posicionX, posicionY));
		this.img1 = Herramientas.cargarImagen("recursos/princesa-frente.png");
		//this.angulo = 0;
		this.altura= 50;
		this.ancho = 50;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.getCoordenadas().getX(), this.getCoordenadas().getY(), 0, 0.6);
	}

	public void moverDerecha() {
		this.getCoordenadas().moverXCantidad(true, 3);
		this.imagenCargada = "recursos/princesa-der.png";
		this.img1 = Herramientas.cargarImagen(imagenCargada);
		this.posicionDerecha=true;
	}

	public void moverIzquierda() {
		this.getCoordenadas().moverXCantidad(false, 3);
		this.imagenCargada = "recursos/princesa-izq.png";
		this.img1 = Herramientas.cargarImagen(imagenCargada);
		this.posicionDerecha=false;
	}

	public void saltar(Entorno entorno) {
		imagenCargada = "recursos/princesa-salto.png";
		for(int x = 0; x<150; x++) {
			this.img1 = Herramientas.cargarImagen(imagenCargada);
			this.getCoordenadas().moverYCantidad(true, 1);
		}
	}
	
	public void enIdle(Entorno entorno) {
		imagenCargada = "recursos/princesa-frente.png";
		img1 = Herramientas.cargarImagen(imagenCargada);
	}


	

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	public void Dibujarcuadrado(Entorno e) {
		e.dibujarRectangulo(coordenadas.getX(), coordenadas.getY(), ancho, altura, 0, Color.RED);
	
	
	}
	
	public int getY() {
		return this.coordenadas.getY();
	}
	
	public int getX() {
		return this.coordenadas.getX();
	}
	
	public boolean EstaColision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
}

	
}
