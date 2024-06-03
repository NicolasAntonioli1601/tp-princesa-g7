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
	
	double[] Fila3Fijo = new double[16];double[] Fila2Fijo = new double[16];double[] Fila1Fijo = new double[16];
	double[] Fila3Random = new double[16];double[] Fila2Random = new double[16];double[] Fila1Random = new double[16];
	Juego() {

		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");

		cuadrado = new Cuadrado(300, 550, 50, 50);
		cubo = new Cubo(300, 550, 50, 50, true, true);
		cubo.ListaAgregar(Fila1Fijo,Fila1Random);
		cubo.ListaAgregar(Fila2Fijo,Fila2Random);
		cubo.ListaAgregar(Fila3Fijo,Fila3Random);
		System.out.println(Fila1Random.length);

		this.princesa = new Princesa(400, 540);
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
		entorno.cambiarFont(null, 20, new Color(255, 255, 255));
		fondo.dibujarse(entorno);
		// GRAVEDAD, si no esta en el margen de abajo (aprox 550) tiene que decrementar
		// si o si para abajo el y.
		// (agregar condicion cuando haya bloques)

		

		
		cubo.DibujarCubos(entorno, Fila1Fijo, Fila1Random, 450);
		cubo.DibujarCubos(entorno, Fila2Fijo, Fila2Random, 300);
		cubo.DibujarCubos(entorno, Fila3Fijo, Fila3Random, 150);
		
		if (this.princesa != null) {
			if (this.princesa.getCoordenadas().getY() <= 540  )   {		//550
				this.princesa.getCoordenadas().moverYCantidad(false, 5);
			} 
//			if (this.princesa.getCoordenadas().getY() <= 425 )   {
//				this.princesa.getCoordenadas().setY(400);
//				
//			}
			this.princesa.setEntorno(entorno);

			princesa.dibujarse(entorno);

			if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)
					|| this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) || this.entorno.estaPresionada('x')) {
				this.princesa.moverDerecha();
				this.princesa.moverIzquierda();
				this.princesa.saltar();
			} else {
				this.princesa.img1 = Herramientas.cargarImagen("recursos/princesa-frente.png");
			}

		}
		cubo.Colision(princesa,Fila1Fijo ,Fila1Random,450 );
		cubo.Colision(princesa,Fila2Fijo ,Fila2Random,300 );
		cubo.Colision(princesa,Fila3Fijo ,Fila3Random,150 );
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
