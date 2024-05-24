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
	private Cuadrado cuadrado;
	private Cubo cubo;
	Random random = new Random();
	private Fondo fondo;
	private Princesa princesa;
	private Coordenada coordenadas;
	private Tiro tiro;
	List<Cubo> Columna1 = new ArrayList<>();
	List<Cubo> Columna2 = new ArrayList<>();
	List<Cubo> Columna3 = new ArrayList<>();

	Juego() {

		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");

		cuadrado = new Cuadrado(300, 550, 50, 50);
		cubo = new Cubo(300, 550, 50, 50, true, true);
		this.princesa = new Princesa(400, 540, 50, 50);

		cubo.AgregarCubos(Columna1, 16, 450);
		cubo.AgregarCubos(Columna2, 16, 300);
		cubo.AgregarCubos(Columna3, 16, 150);
		cubo.Destruircubo(Columna1, princesa, entorno);

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
		cubo.DibujarLista(Columna1, entorno);
		cubo.DibujarLista(Columna2, entorno);
		cubo.DibujarLista(Columna3, entorno);
		cubo.Destruircubo(Columna1, princesa, entorno);

		// PRINCESA

		// GRAVEDAD, si no esta en el margen de abajo (aprox 550) tiene que decrementar
		// si o si para abajo el y.
		// (agregar condicion cuando haya bloques)

		if (this.princesa != null) {
			if (this.princesa.getCoordenadas().getY() <= 550 && this.princesa.sobreFila() == false) {
				this.princesa.getCoordenadas().moverYCantidad(false, 5);
			}

			this.princesa.setEntorno(entorno);

			princesa.dibujarse(entorno);
			
			
			// DISPARO (falta ver para que lado dispara)
			
			if (this.entorno.estaPresionada('c') && this.princesa.tiro == null) {
				this.princesa.dispara();
				this.princesa.tiro.dibujarse(entorno);
			}
			if (this.princesa.tiro != null) {
				if (this.princesa.tiro.estaEnLimite()) {
					this.princesa.tiro.dibujarse(entorno);
					this.princesa.tiro.moverse();
				} else {
					this.princesa.tiro = null;
				}
			}

			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
					|| this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) || this.entorno.estaPresionada('x')) {
				this.princesa.moverDerecha();
				this.princesa.moverIzquierda();
				this.princesa.saltar();
			} else {
				this.princesa.img1 = Herramientas.cargarImagen("recursos/princesa-frente.png");
			}

		}
	}

	

	public boolean colision(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
