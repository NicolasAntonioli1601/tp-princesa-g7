package juego;


import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Puntaje puntos;
	// Variables y métodos propios de cada grupo
	// ...
	private Cubo cubo;
	Random random = new Random();
	private Fondo fondo;
	private Princesa princesa;
	private Fila[] filas;
	
	double[] Fila3Fijo = new double[16];double[] Fila2Fijo = new double[16];double[] Fila1Fijo = new double[16];
	double[] Fila3Random = new double[16];double[] Fila2Random = new double[16];double[] Fila1Random = new double[16];
	Juego() {
		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");
		
		this.filas = new Fila[3];
		int alturaPiso = 450;
		for(int x = 0; x<3; x++) {
			this.filas[x] = new Fila(new Coordenada(0, alturaPiso), 16);
			alturaPiso -= 150;
		}
		
		cubo = new Cubo(300, 550, 50, 50, true, true);
		cubo.ListaAgregar(Fila1Fijo,Fila1Random);
		cubo.ListaAgregar(Fila2Fijo,Fila2Random);
		cubo.ListaAgregar(Fila3Fijo,Fila3Random);

		this.princesa = new Princesa(400, 540);
		cubo.Colision(princesa,Fila1Fijo ,Fila1Random, 0 );
		
		this.puntos = new Puntaje();
		this.fondo = new Fondo(400, 300, "fondo.png");
		
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
		// GRAVEDAD, si no esta en el margen de abajo (aprox 550) tiene que decrementar
		// si o si para abajo el y.
		// (agregar condicion cuando haya bloques)
		
		
		Fila.dibujarFilas(this.filas, entorno);
		
		if (this.princesa != null) {
			this.princesa.setEntorno(entorno);
			
			/*if (this.princesa.getCoordenadas().getY() <= posicionYPisoActual)   {		//550
				this.princesa.getCoordenadas().moverYCantidad(false, 5);
			}*/

			
/*
			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
					|| this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) || this.entorno.estaPresionada('x')) {
				this.princesa.moverDerecha();
				this.princesa.moverIzquierda();
				this.princesa.saltar();
			} else {
				this.princesa.img1 = Herramientas.cargarImagen("recursos/princesa-frente.png");
			}
*/		
			if(this.entorno.sePresiono('x')) {
				this.princesa.saltar(entorno);
			}else if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
				this.princesa.moverDerecha();
			}else if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
				this.princesa.moverIzquierda();
			}else {
				this.princesa.enIdle(entorno);
			}
			princesa.dibujarse(entorno);
		}
		
		for(Fila fila : this.filas) {
			for(Cubo cubo : fila.getCubos()) {
				if(cubo.colisionaConPrincesa(princesa) && this.princesa.getCoordenadas().getY() < cubo.getY()) {
					if(cubo.isTipo()) {
						cubo = null;
					}
					else {
						princesa.setCoordenadas(new Coordenada(princesa.getX(), princesa.getY()-20));
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
