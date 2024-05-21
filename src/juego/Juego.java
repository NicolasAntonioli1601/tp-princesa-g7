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
	// Variables y métodos propios de cada grupo
	// ...
	private Cuadrado cuadrado;
	private Cubo cubo;
	Random random = new Random();
	private Entorno entorno;
	private Fondo fondo;
	
	List<Cubo> Columna1 =new ArrayList<>();
	List <Cubo> Columna2 = new ArrayList <>();
	List <Cubo> Columna3 = new ArrayList <>();
	Juego() {
		
		this.entorno = new Entorno(this, "TpPrincesa", 800, 600);
		this.fondo = new Fondo(400, 300, "fondo.png");
		cuadrado = new Cuadrado(300,550,50,50);
		cubo  =new Cubo (300,550,50,50,true,true);
		 
		cubo.AgregarCubos(Columna1, 16, 450);
		cubo.AgregarCubos(Columna2, 16, 300);
		cubo.AgregarCubos(Columna3, 16, 150);
		cubo.Destruircubo(Columna1,cuadrado,entorno);
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
		fondo.dibujarse(entorno);
		cuadrado.Dibujar(entorno);
		
		
		
		if (cuadrado.getX() >= 30 && entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
				cuadrado.MoverIzq();
		
		if  (cuadrado.getX() <= 770 &&entorno.estaPresionada(entorno.TECLA_DERECHA))
			cuadrado.MoverDer();
		
		if  (cuadrado.getX() >= 30 && cuadrado.getX() <= 770 &&entorno.estaPresionada(entorno.TECLA_ARRIBA))
			cuadrado.Saltar();
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)== false)
			cuadrado.Caer();
		
		
		cubo.DibujarLista(Columna1,entorno);
		cubo.DibujarLista(Columna2,entorno);
		cubo.DibujarLista(Columna3,entorno);
		cubo.Destruircubo(Columna1,cuadrado,entorno);
		
	}

	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}
