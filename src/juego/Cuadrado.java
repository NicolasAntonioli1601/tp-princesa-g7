package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Cuadrado {
	private double x;
	private double y;
	private int altura;
	private int ancho;
	private int desplazamiento = 5;
	Image img1;

	public Cuadrado(double x, double y, int altura, int ancho) {
		super();
		this.x = x;
		this.y = y;
		this.altura = altura;
		this.ancho = ancho;
	}

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

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getDesplazamiento() {
		return desplazamiento;
	}

	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	public void Dibujar(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, altura, 0, Color.ORANGE);
	}

	public void DibujarPiso(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, altura, 0, Color.RED);
	}

	public void DibujarColumna(Entorno e) {
		img1 = Herramientas.cargarImagen("cuadrado.png");
		e.dibujarImagen(img1, this.x, this.y, 0, 0.1);
	}

	public void MoverIzq() {
		x -= desplazamiento;
	}

	public void MoverDer() {
		x += desplazamiento;
	}

	public void Saltar() {
		y -= 10;
	}

	public void Caer() {
		if (y > 550) {
			y += 4;
		} else {
			y = 550;
		}

	}

	public void DibujarColumna0 (Entorno e) {
		int PosY = 1;
		int CantCuadrados= 17;
		Cuadrado cuadrado;
		while (CantCuadrados != 0) {
			cuadrado = new Cuadrado(PosY, 600, 50, 50);
			cuadrado.DibujarPiso(e);
			CantCuadrados--;
			PosY = PosY + 50;
			
				
			}
	}

	public void DibujarColumna1 (Entorno e) {
			int PosY = 25;
			int CantCuadrados= 16;
			Cuadrado cuadrado;
			while (CantCuadrados != 0) {
				cuadrado = new Cuadrado(PosY, 450, 50, 50);
				cuadrado.DibujarColumna(e);
				CantCuadrados--;
				PosY = PosY + 50;
					
				}
				
		}

	public void DibujarColumna2 (Entorno e) {
				int PosY = 25;
				int CantCuadrados= 16;
				Cuadrado cuadrado;
				while (CantCuadrados != 0) {
					cuadrado = new Cuadrado(PosY,300, 50, 50);
					cuadrado.DibujarColumna(e);
					CantCuadrados--;
					PosY = PosY + 50;
						
					}
						
					
					
			}

	public void DibujarColumna3(Entorno e) {
		int PosY = 25;
		int CantCuadrados = 16;
		 
		Cuadrado cuadrado;
		while (CantCuadrados != 0) {
			cuadrado = new Cuadrado(PosY, 150, 50, 50);
			cuadrado.DibujarColumna(e);
			
			CantCuadrados--;
			PosY = PosY + 50;

		}
	}

}