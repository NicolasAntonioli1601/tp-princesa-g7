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
	
	private Fila[] filas;
	private Tiranosaurio[] dinos;
	Juego() {

		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");
		
		this.filas = new Fila[3];
		int alturaPiso = 450;
		for(int x = 0; x<3; x++) {
			this.filas[x] = new Fila(new Coordenada(0, alturaPiso), 16);
			alturaPiso -= 150;
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
		// GRAVEDAD, si no esta en el margen de abajo (aprox 550) tiene que decrementar
		// si o si para abajo el y.
		// (agregar condicion cuando haya bloques)
		
		if (this.princesa != null) {
			System.out.println(this.princesa.getPiso());
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
				this.princesa.tiro.dibujarse(entorno);
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
		
		for(Fila fila : this.filas) {
			for(Cubo cubo : fila.getCubos()) {
				if (this.princesa.getY() > cubo.getY() + 25){
					if(!cubo.isRompible()) {
						princesa.setPiso((int) cubo.getY());
					}
					else {
						princesa.setPiso((int) cubo.getY()-150);
					}
				}
				
				if(cubo.colisionaConPrincesa(princesa)) {
					if(cubo.isRompible()) {
						cubo.setEstado(false);
					}
					else {
						this.princesa.getCoordenadas().moverYCantidad(false, 5);
						this.princesa.setPiso(fila.getCoordenadas().getY() - 150);
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
