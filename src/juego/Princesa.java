package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	private Entorno entorno;
	boolean posicionDerecha;
	Image img1;
	Tiro tiro;
	private int piso;

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	
	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	public int getX() {
		return this.coordenadas.getX();
	}
	
	public int getY() {
		return this.coordenadas.getY();
	}

	public Princesa(int posicionX, int posicionY, double ancho, double altura) {
		this.setCoordenadas(new Coordenada(posicionX, posicionY));
		this.img1 = Herramientas.cargarImagen("recursos/princesa-frente.png");
		//this.angulo = 0;
		this.altura= 50;
		this.ancho = 50;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.getCoordenadas().getX(), this.getCoordenadas().getY(), 0, 0.4);
	}

	public void moverDerecha() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.getCoordenadas().getX() <= 750) {
			this.getCoordenadas().moverXCantidad(true, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-der.png");
			this.posicionDerecha=true;
		}
	}

	public void moverIzquierda() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.getCoordenadas().getX() >= 50) {
			this.getCoordenadas().moverXCantidad(false, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-izq.png");
			this.posicionDerecha=false;
		}
		
		
	}

	public void saltar() {
		char a = 'x';
		if (this.entorno.estaPresionada(a) && this.getCoordenadas().getY() >= 50) {
			this.img1 = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().moverYCantidad(true, 20);

		}
	}


	public void dispara() {

		this.tiro = new Tiro(this.coordenadas.getX() - 20, this.coordenadas.getY(), this.posicionDerecha);
		
	}

	
	public void Dibujarcuadrado(Entorno e) {
		e.dibujarRectangulo(coordenadas.getX(), coordenadas.getY(), ancho, altura, 0, Color.RED);
	
	
	}
	
	public boolean EstaColision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
}

	
}
