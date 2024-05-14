package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Cuadrado {
	double ancho;
	double altura;
	double x;
	double y;
	private Entorno entorno;
	double velocidad;
	String direccion;
	Image img1;

	public Cuadrado(Entorno entorno, int x, int y, String direccion) {
		super();
		this.ancho = 100;
		this.altura = 100;
		this.x = x;
		this.y = y;
		this.velocidad = 15;
		this.entorno = entorno;
		this.direccion = direccion;
		this.img1 = Herramientas.cargarImagen("personaje-nice.png");
	}

	public void Dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, altura, 0, Color.pink);
		entorno.dibujarImagen(img1, this.x, this.y, 0, 0.1);
	}

	public void avanzarArriba() {
		this.y-=this.velocidad;
		
	}

	public void avanzarAbajo() {
		this.y+= this.velocidad;
	}

	public void avanzarDerecha() {
		this.x = x + this.velocidad;
	}

	public void avanzarIzquierda() {
		this.x = x - this.velocidad;
	}

}
