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
	private Cubo cubo;
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
				this.dinos[dino] = new Tiranosaurio(500, 90, 50, 50,false);
				
			if(dino == 1)
				this.dinos[dino] = new Tiranosaurio(200, 90, 50, 50,true);
				
			if(dino == 2)
				this.dinos[dino] = new Tiranosaurio(500, 240, 50, 50,false);
				//tiro[tiros]= new TiroDino (500, 240, false);
			if(dino == 3)
				this.dinos[dino] = new Tiranosaurio(200, 240, 50, 50,true);
				//tiro[tiros]= new TiroDino (200, 240, true);
			if(dino == 4)
				this.dinos[dino] = new Tiranosaurio(530, 390, 50, 50,false);
				//tiro[tiros]	= new TiroDino (530, 390, false);
			if(dino == 5)
				this.dinos[dino] = new Tiranosaurio(200 , 390, 50, 50,true);
				//tiro[tiros]= new TiroDino (200 , 390, true);
			
				
			}
			
			
		
		
		this.princesa = new Princesa(400, 500, 50, 50);
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
		
		tiro[0].dibujarse(entorno);
		tiro[0].moverse();
		
		tiro[1].dibujarse(entorno);
		tiro[1].moverse();
		
		tiro[2].dibujarse(entorno);
		tiro[2].moverse();
		
		tiro[3].dibujarse(entorno);
		tiro[3].moverse();
		
		tiro[4].dibujarse(entorno);
		tiro[4].moverse();
		
		tiro[5].dibujarse(entorno);
		tiro[5].moverse();
		
//		tiro[1].dibujarse(entorno);
//		tiro[1].moverse();
		Tiranosaurio.mover(dinos, 0, entorno, Tiro);
		
		
		
//		
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
			//System.out.println(this.princesa.getPiso());
			if (this.princesa.getCoordenadas().getY() > this.princesa.getPiso())   {		//550
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
			if(
				x < 3
				&&
				this.princesa.getY() < filas[x].getCoordenadas().getY()
				&&
				this.princesa.getY() > filas[x+1].getCoordenadas().getY()
			) {
				for(Cubo cubo : filas[x].getCubos()) {
					if(this.princesa.getX() < cubo.getX() - 20 && this.princesa.getX() > cubo.getX() + 20) {
						//if (this.princesa.getY() < cubo.getY()){
							if(!cubo.isRompible()) {
								princesa.setPiso((int) cubo.getY() + 150);
							}
							else {
								princesa.setPiso((int) cubo.getY());
							}
						//}
					}
					
					if(cubo.colisionaConPrincesa(princesa)) {
						if(cubo.isRompible()) {
							cubo.setEstado(false);
						}
						else {
							this.princesa.getCoordenadas().moverYCantidad(false, 5);
							this.princesa.setPiso(filas[x].getCoordenadas().getY() - 150);
						}
					}
				}
			}
			if(this.princesa.getY() < filas[x].getCoordenadas().getY()) {
				for(Cubo cubo : filas[x].getCubos()) {
					if (this.princesa.getY() < cubo.getY()){
						if(!cubo.isRompible()) {
							princesa.setPiso((int) cubo.getY() + 150);
						}
						else {
							princesa.setPiso((int) cubo.getY());
						}
					}
					
					if(cubo.colisionaConPrincesa(princesa)) {
						if(cubo.isRompible()) {
							cubo.setEstado(false);
						}
						else {
							this.princesa.getCoordenadas().moverYCantidad(false, 5);
							this.princesa.setPiso(filas[x].getCoordenadas().getY() - 150);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
