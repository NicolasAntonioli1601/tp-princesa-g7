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
	
	private double gravedad;
	
	private double salto;
	
	private double velocidadDeSalto;
	
	private double posicionDelSuelo;
	
	private String direccion;
	
	boolean posicionDerecha;
	Image imagenEstado;
	Tiro tiro;
	private int piso;

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
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
		this.imagenEstado = Herramientas.cargarImagen("recursos/princesa-frente.png");
		//this.angulo = 0;
		this.altura= 50;
		this.ancho = 50;
		this.piso = posicionY;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagenEstado, this.getCoordenadas().getX(), this.getCoordenadas().getY(), 0, 0.4);
	}

	public void moverDerecha() {
		this.getCoordenadas().moverXCantidad(true, 3);
		this.imagenEstado = Herramientas.cargarImagen("recursos/princesa-der.png");
		this.posicionDerecha=true;
	}

	public void moverIzquierda() {
		this.getCoordenadas().moverXCantidad(false, 3);
		this.imagenEstado = Herramientas.cargarImagen("recursos/princesa-izq.png");
		this.posicionDerecha=false;
	}

	public void saltar() {
		if(this.getY() > 0) {
			this.imagenEstado = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().moverYCantidad(true, 20);
		}
		else{
			this.imagenEstado = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().setY(0);
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
