package juego;

import java.awt.Image;
import java.util.List;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;

public class Cubo {
	private double y;
	private double x;
	private int altura;
	private int ancho;
	private boolean estado;
	private boolean tipo;
	Image imgCubo, imgcubo2,Ladrillo;
	Random random = new Random();
	

	public Cubo(double x, double y, int altura, int ancho, boolean estado, boolean tipo) {
		this.y = y;
		this.x = x;
		this.altura = altura;
		this.ancho = ancho;
		this.estado = estado;
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
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

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public void AgregarCubos(List<Cubo> nombre, int Cantidad, double posY) {

		int cubo1= random.nextInt(16);
		int cubo2= random.nextInt(16);
		int cubo3= random.nextInt(16);
		int cubo4= random.nextInt(16);
		int posicionX = 25;
		
		while (Cantidad != 0) {
			if (cubo1==Cantidad ||cubo2==Cantidad||cubo3==Cantidad||cubo4==Cantidad ) {
				Cubo cubo = new Cubo(posicionX, posY, 50, 50, false, true);
				nombre.add(cubo);
				Cantidad--;
				posicionX = posicionX + 50;
			}else{
				Cubo cubo = new Cubo(posicionX, posY, 50, 50, false, false);
				nombre.add(cubo);
				Cantidad--;
				posicionX = posicionX + 50;
			}
		}
	}

	public void DibujarCuboFijo(Entorno e, double x, double y, int ancho, int altura) {
		imgCubo = Herramientas.cargarImagen("cubo fijo.png");
		e.dibujarImagen(imgCubo, this.x, this.y, 0, 0.3);

	}

	public void DibujarCuboRomp(Entorno e, double x, double y, int ancho, int altura) {
		imgcubo2 = Herramientas.cargarImagen("cuadrado.png");
		e.dibujarImagen(imgcubo2, this.x, this.y, 0, 0.1);

	}
	public void DibujarLadrillo(Entorno e, double x, double y, int ancho, int altura) {
		imgcubo2 = Herramientas.cargarImagen("ladrillo.png");
		e.dibujarImagen(imgcubo2, this.x, this.y, 0, 0.6);

	}

	public void DibujarLista(List<Cubo> nombre, Entorno e) {
		
		
		for (int i = 0; i < nombre.size(); i++) {
			if (nombre.get(i).isTipo() != true) {
				nombre.get(i).DibujarCuboFijo(e, nombre.get(i).getX(), nombre.get(i).getY(), nombre.get(i).getAncho(),
						nombre.get(i).getAltura());
				
			} else {
				nombre.get(i).DibujarCuboRomp(e, nombre.get(i).getX(), nombre.get(i).getY(), nombre.get(i).getAncho(),
						nombre.get(i).getAltura());
				
			}

		}
	}

	public void Destruircubo(List<Cubo> nombre,Cuadrado cuadrado,Entorno e) {
		Cubo datos;
		for (int i = 0; i < nombre.size(); i++) {
			if (nombre.get(i).isTipo()==true && cuadrado.getY() == nombre.get(i).getY() &&
			cuadrado.getX() == nombre.get(i).getX() ) {
				datos = nombre.get(i);
				datos.DibujarLadrillo(e,datos.getX(),datos.getX(),25,10);
				nombre.remove(i);
				break;
				
		}
			
		}
		
	}

	public void CuboDestruido (double x,double y,Entorno e) {
		Cubo Ladrillo1;
		Cubo Ladrillo2;
		Ladrillo1 = new Cubo(x,y,25,10, true, true);
		Ladrillo2 = new Cubo(x,y,25,10, true, true);
		
		Ladrillo1.DibujarLadrillo(e, x+30, y+50, 25,10);
		Ladrillo2.DibujarLadrillo(e, x+30, y+45, 25,10);
		
	}
}
