package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	// Variables y métodos propios de cada grupo
	// ...
	private Cubo [] cubo;
	Random random = new Random();
	private Fondo fondo;
	private Princesa princesa;
	private TiroDino Tiro;
	private Fila[] filas;
	private Tiranosaurio[] dinos;
	private TiroDino [] tiro;
	Juego() {
		
		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");
		
		this.filas = new Fila[3];
		int alturaPiso = 450;
		for(int x = 0; x<3; x++) {
			this.filas[x] = new Fila(new Coordenada(0, alturaPiso), 16);

			alturaPiso -= 150;
		}
		
		
		this.dinos = new Tiranosaurio [6];
		this.tiro = new TiroDino [7];
			
		
		for (int tiros = 0; tiros <tiro.length; tiros++) {
			System.out.println(tiros);
			if(tiros == 0 ) 
				tiro[tiros] = new TiroDino (500, 90, false);
			if(tiros == 1 ) 
				tiro[tiros] = new TiroDino (200, 90, true);
			if(tiros == 2 ) 
				tiro[tiros] = new TiroDino (500, 240, false);
			if(tiros == 3 ) 
				tiro[tiros] = new TiroDino (200, 240, true);
			if(tiros == 4 ) 
				tiro[tiros] = new TiroDino (530, 390, false);
			if(tiros == 5 ) 
				tiro[tiros] = new TiroDino (200, 390, true);
		}
		
		
			for (int dino = 0; dino <dinos.length; dino++) {
				
					
					
				
				
			if(dino == 0 ) 
				this.dinos[dino] = new Tiranosaurio(500, 90, 50, 50,false,true);
				
			if(dino == 1)
				this.dinos[dino] = new Tiranosaurio(200, 90, 50, 50,true,true);
				
			if(dino == 2)
				this.dinos[dino] = new Tiranosaurio(500, 240, 50, 50,false,true);
				//tiro[tiros]= new TiroDino (500, 240, false);
			if(dino == 3)
				this.dinos[dino] = new Tiranosaurio(200, 240, 50, 50,true,true);
				//tiro[tiros]= new TiroDino (200, 240, true);
			if(dino == 4)
				this.dinos[dino] = new Tiranosaurio(530, 390, 50, 50,false,true);
				//tiro[tiros]	= new TiroDino (530, 390, false);
			if(dino == 5)
				this.dinos[dino] = new Tiranosaurio(200 , 390, 50, 50,true,true);
				//tiro[tiros]= new TiroDino (200 , 390, true);
			
				
			}
		this.princesa = new Princesa(400, 540, 50, 50);
		//cubo.Colision(princesa,Fila1Fijo ,Fila1Random );
		
		
		
	
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		
		double posicionYPiso = 540;
		double posicionYPisoActual = posicionYPiso;
		
		entorno.cambiarFont(null, 20, new Color(255, 255, 255));
		fondo.dibujarse(entorno);
		Fila.dibujarFilas(this.filas, entorno);
	
		
			
		//System.out.println(tiro[0].getX());
		


		Tiranosaurio.tiro(dinos, 0, entorno, tiro, 0);
		Tiranosaurio.tiro(dinos, 1, entorno, tiro, 1);
		Tiranosaurio.tiro(dinos, 2, entorno, tiro, 2);
		Tiranosaurio.tiro(dinos, 3, entorno, tiro, 3);
		Tiranosaurio.tiro(dinos, 4, entorno, tiro, 4);
		Tiranosaurio.tiro(dinos, 5, entorno, tiro, 5);
		
		

		Tiranosaurio.mover(dinos, 0, entorno, Tiro);
		Tiranosaurio.mover(dinos, 1, entorno, Tiro);
		Tiranosaurio.mover(dinos, 2, entorno, Tiro);
		Tiranosaurio.mover(dinos, 3, entorno, Tiro);
		Tiranosaurio.mover(dinos, 4, entorno, Tiro);
		Tiranosaurio.mover(dinos, 5, entorno, Tiro);
	

		
		
		//Tiranosaurio.movimientosDer(dinos, entorno,2);
		
		// GRAVEDAD, si no esta en el margen de abajo (aprox 550) tiene que decrementar
		// si o si para abajo el y.
		// (agregar condicion cuando haya bloques)
		//tiranos.DibujarTirano(entorno);
		//tiranos.dibujarTiranosaurio(tiranos, entorno);
		
		
		if (this.princesa != null) {
			System.out.println(this.princesa.getPiso());
			if (this.princesa.getCoordenadas().getY() < this.princesa.getPiso())   {		//550
				if(!(this.princesa.getY() > posicionYPiso)) {
					this.princesa.getCoordenadas().moverYCantidad(false, 10);
				}
			}
			
			princesa.dibujarse(entorno);
			
			
			if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
				this.princesa.moverIzquierda();
			}
			if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
				this.princesa.moverDerecha();
			}
			if(this.entorno.estaPresionada('x')) {
				this.princesa.saltar();
			}
			
			if(this.entorno.estaPresionada('c') && this.princesa.tiro == null) {
				this.princesa.dispara();
				//this.princesa.tiro.dibujarse(entorno);
			}
			if(this.princesa.tiro != null) {
				if(this.princesa.tiro.estaEnLimite()) {
					this.princesa.tiro.dibujarse(entorno);
					this.princesa.tiro.moverse();
				}
				else {
					this.princesa.tiro = null;
				}
			}

		}
		
		for(int x = 0; x < filas.length; x++) {
			for(Cubo cubo : filas[x].getCubos()) {
				if(x < filas.length -1) {
					if(filas[x].getCoordenadas().getY() > this.princesa.getY()) {
						if(cubo.getX()-20 < this.princesa.getX() && cubo.getX() < this.princesa.getX()+20) {
							this.princesa.setPiso(filas[x].getCoordenadas().getY());
						}
					}
				}
				
				if(cubo.colisionaConPrincesa(princesa)) {
					if(cubo.isRompible()) {
						cubo.setEstado(false);
					}
					else {
						this.princesa.getCoordenadas().moverYCantidad(false, 5);
					}
				}
			}
		}
	
		for(Fila fila : this.filas) {
			for(Cubo cubo : fila.getCubos()) {
				//System.out.println(cubo.getY());
				if (cubo.isEstado()== false && cubo.colisionaConDinos(dinos)) {				
					dinos[5].setQuieto(false);
					//System.out.println(cubo.colisionaConDinos(dinos));
					if (dinos[5].isQuieto() == false && dinos[5].getX()>150) {
						Tiranosaurio.caer(dinos, entorno, 5);
					}
										
					dinos[5].setQuieto(true);
				}
				
			}
		}
	
	//System.out.println(dinos[5].getY());
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
