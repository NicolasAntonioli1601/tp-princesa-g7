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
	private boolean quieto;
	
	public boolean isQuieto() {
		return quieto;
	}



	public void setQuieto(boolean quieto) {
		this.quieto = quieto;
	}


	TiroDino a;
	// CONTRUCTOR
	public Tiranosaurio(double posicionX, double posicionY, double altura, double ancho,boolean sentido, boolean quieto) {
		this.x = posicionX;
		this.y = posicionY;
		this.altura = altura;
		this.ancho = ancho;
		this.sentido = sentido;
		this.quieto =quieto;
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
	public static void caer(Tiranosaurio[] dinos, Entorno e,int num) {	
			dinos[num].y += 150;
				
		
		
			
	}
	public static void movimientosIzq(Tiranosaurio[] dinos, Entorno e,int num) {	
		
		dinos[num].x -= 1;
			
	}
	public static void movimientosDer(Tiranosaurio[] dinos, Entorno e,int num) {
	
		dinos[num].x += 1;

	}
	public static void mover(Tiranosaurio[] dinos,int num,Entorno entorno,TiroDino tiro) {
		if ( dinos[num] != null) {
		if(dinos[num].isQuieto()==false && dinos[num] != null) {
			dinos[num].DibujarTiranocentro(entorno);
		}
		
		
		if (dinos[num].getX()>=30&&dinos[num].isSentido()== false && dinos[num].isQuieto()&& dinos[num] != null) {
			Tiranosaurio.movimientosIzq(dinos, entorno, num);
			dinos[num].DibujarTiranoIzq(entorno);
			
			
			
		}
		if (dinos[num].getX()==30&& dinos[num] != null) {
			dinos[num].setSentido(true);
			
		}
		if (dinos[num].getX()<=750&&dinos[num].isSentido()== true && dinos[num].isQuieto()&& dinos[num] != null) {
			Tiranosaurio.movimientosDer(dinos, entorno, num);
			dinos[num].DibujarTiranoDer(entorno);
			
			
		}	
		if (dinos[num].getX()==750&& dinos[num] != null) {
			dinos[num].setSentido(false);
		}
		}
	}
	
	
	// TiROS TIRANOS

		
	public static void tiro(Tiranosaurio[] dinos,int dino,Entorno entorno,TiroDino[] tiros,int tiro) {
		double altura = 0;
		if (dino== 0 && dinos[0] != null)
			altura= dinos[dino].getY();
		
		if (dino== 1 && dinos[1] != null)
			altura= dinos[dino].getY();
		
		if (dino== 2 && dinos[2] != null)
			altura= dinos[dino].getY();
		
		if (dino== 3 && dinos[3] != null)
			altura= dinos[dino].getY();
		
		if (dino== 4 && dinos[4] != null)	
			altura= dinos[dino].getY();
		
		if (dino== 5&& dinos[5] != null)
			altura= dinos[dino].getY();

		if (tiros[tiro]!= null && dinos[dino].isQuieto()==true) {	
			if(tiros[tiro].estaEnLimite() && dinos[dino].getX()>90 && dinos[dino].getX()<700) {
				tiros[tiro].dibujarse(entorno);
				tiros[tiro].moverse();		
			}
			else {
				tiros[tiro] = null;
				if (tiros[tiro] == null && dinos[dino].isQuieto()==true&& dinos[dino] != null) {	
					if (dinos[tiro].isSentido()==false&& dinos[dino] != null) {
						tiros[tiro] = new TiroDino (dinos[dino].getX(), altura, false);
					}else {
						tiros[tiro] = new TiroDino (dinos[dino].getX(), altura, true);
					}			
				}	
					}
				}
	}

		
	// Colision
	public static void colisicionDino(Tiranosaurio[]dinos,int Ndino,Entorno entorno,Fila [] filas) {
		for(Fila fila : filas) {
			for(Cubo cubo : fila.getCubos()) {
					
				if (cubo.isEstado()== false && cubo.colisionaConDinos(dinos,Ndino)) {				
					dinos[Ndino].setQuieto(false);
					
					if (dinos[Ndino].isQuieto() == false && dinos[Ndino].getX()>150 ) {
						Tiranosaurio.caer(dinos, entorno, Ndino);
					}
										
					dinos[Ndino].setQuieto(true);
				}
				
			}
		}
	
	}
	
		

		

			
	
}
