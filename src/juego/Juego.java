package juego;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	// ...
	private Cuadrado cuadrado;
	private Fondo fondo;

	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "El juego del cuadrado", 800, 600);
		// hago algun cambio
		// Inicializar lo que haga falta para el juego
		// ...

		// Inicia el juego!
		cuadrado = new Cuadrado(entorno, 5, 5, "ARRIBA");
		fondo = new Fondo(100, 200);
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
		fondo.cambiarAngulo();
		fondo.dibujarse(entorno);
		if (this.cuadrado != null) {
			cuadrado.Dibujar(entorno);
			

			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& this.cuadrado.x + this.cuadrado.ancho/2  <800){
				this.cuadrado.avanzarDerecha();
			
			} else if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.cuadrado.x - this.cuadrado.ancho>0) {
				this.cuadrado.avanzarIzquierda();
			
			} else if (this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.cuadrado.y+ this.cuadrado.altura/2<= 600) {
				this.cuadrado.avanzarAbajo();
			
			} else if (this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA) &&  this.cuadrado.y- this.cuadrado.altura/2>= 0) {
				this.cuadrado.avanzarArriba();
			}
		
			
		if (this.entorno.estaPresionada('x')) {
			this.cuadrado = null;
			}
		}
		
		if (this.entorno.estaPresionada('y')) {
			this.cuadrado = new Cuadrado(entorno, 28, 25, "ARRIBA");
		}
		
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
