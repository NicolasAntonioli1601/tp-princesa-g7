package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	Image img1;
	private double angulo;
	private Entorno entorno;

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public Princesa(int posicionX, int posicionY) {
		super();
		this.setCoordenadas(new Coordenada(posicionX, posicionY));
		this.img1 = Herramientas.cargarImagen("recursos/princesa-frent.png");
		this.angulo = 0;
		this.altura= 50;
		this.ancho = 50;
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.getCoordenadas().getX(), this.getCoordenadas().getY(), this.angulo, 0.3);
	}

	public void moverDerecha() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)  && this.getCoordenadas().getX()<=750) {
			this.getCoordenadas().moverXCantidad(true,3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-der.png");
		}
	}

	public void moverIzquierda() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& this.getCoordenadas().getX()>=50 ) {
			this.getCoordenadas().moverXCantidad(false,3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-izq.png");

		}
	}

	public void saltar() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& this.getCoordenadas().getY()>=50) {
			this.img1 = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().moverYCantidad(true, 10);

		} 
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
	
	public boolean EstaColision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
}

	
}
