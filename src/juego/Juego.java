package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Label puntaje;
	// Variables y métodos propios de cada grupo
	// ...
	private Fondo fondo;
	private Princesa princesa;
	private Coordenada coordenada;

	Juego() {

		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);

		this.puntaje = new Label(20, 30, "Puntaje: ");
		this.fondo = new Fondo(400, 300, "fondo.png");
		this.princesa = new Princesa(400, 540);
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
		entorno.cambiarFont(null, 20, new Color(255, 255, 255));
		fondo.dibujarse(entorno);
		puntaje.dibujar(entorno);

		if (this.princesa != null) {
			princesa.dibujarse(entorno);
			if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)) {
				this.princesa.moverDerecha();
			} else {
				if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)) {
					this.princesa.moverIzquierda();
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
