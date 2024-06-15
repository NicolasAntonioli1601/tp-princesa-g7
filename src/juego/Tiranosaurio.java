package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Tiranosaurio {
	private double x;
	private double y;
	private double altura;
	private double ancho;
	private Image imagenEstado;
	private boolean sentido;
	TiroDino a;
	// CONTRUCTOR
	public Tiranosaurio(double posicionX, double posicionY, double altura, double ancho,boolean sentido) {
		this.x = posicionX;
		this.y = posicionY;
		this.altura = altura;
		this.ancho = ancho;
		this.sentido = sentido;
	}
	
	
	
	//DIBUJADO DE TIRANOS
	public void DibujarTiranocentro(Entorno e) {
		imagenEstado = Herramientas.cargarImagen("recursos/koupa2.png");
		e.dibujarImagen(imagenEstado, this.x, this.y, 0, 0.6);

	}
	public void DibujarTiranoIzq(Entorno e) {
		imagenEstado = Herramientas.cargarImagen("recursos/coupacaminando.png");
		e.dibujarImagen(imagenEstado, this.x, this.y, 0, 0.6);

	}
	public void DibujarTiranoDer(Entorno e) {
		imagenEstado = Herramientas.cargarImagen("recursos/coupacaminandoDer.png");
		e.dibujarImagen(imagenEstado, this.x, this.y, 0, 0.6);

	}
	
	public boolean isSentido() {
		return sentido;
	}
	public void setSentido(boolean sentido) {
		this.sentido = sentido;
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

	
	//MOVIMIENTOS TIRANOS
	public static void movimientosIzq(Tiranosaurio[] dinos, Entorno e,int num) {	
		
		dinos[num].x -= 1;
			
	}
	public static void movimientosDer(Tiranosaurio[] dinos, Entorno e,int num) {
	
		dinos[num].x += 1;

	}
	public static void mover(Tiranosaurio[] dinos,int num,Entorno entorno,TiroDino tiro) {
		if (dinos[num].getX()>=30&&dinos[num].isSentido()== false) {
			Tiranosaurio.movimientosIzq(dinos, entorno, num);
			dinos[num].DibujarTiranoIzq(entorno);
			
			
			
		}
		if (dinos[num].getX()==30) {
			dinos[num].setSentido(true);
			
		}
		if (dinos[num].getX()<=750&&dinos[num].isSentido()== true) {
			Tiranosaurio.movimientosDer(dinos, entorno, num);
			dinos[num].DibujarTiranoDer(entorno);
			
			
		}	
		if (dinos[num].getX()==750) {
			dinos[num].setSentido(false);
		}
	}
	
	
	// COLISIONES TIRANOS
	public static void Tiro(TiroDino tiro,Entorno e){

		tiro = new TiroDino (250, 230, false);
		
		
		
		
			
	}
		

			
	
}
