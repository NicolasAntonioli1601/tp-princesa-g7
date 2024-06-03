package juego;

import java.util.Random;

import entorno.Entorno;

public class Fila {
	private Cubo[] cubos;
	private Coordenada coordenadas;
	
	public Fila(Coordenada posicionInicial, int cantidadCubos){
		//inicializando propiedades
		this.coordenadas = new Coordenada(posicionInicial.getX(), posicionInicial.getY());
		this.cubos = new Cubo[cantidadCubos];
		//preparando variables auxiliares
		boolean esDestructible = false;
		boolean hayDestructible = false;
		Random randomizer = new Random();
		int posicionCuboAnterior = 0;
		
		for(int x = 0; x < cantidadCubos; x++) {
			if(randomizer.nextInt(100) % 6 == 0) { 
				esDestructible = true;
				hayDestructible = true;
			}
			if(!(hayDestructible) && (x == cantidadCubos - 1)) {
				this.cubos[x] = new Cubo(posicionCuboAnterior+50, this.coordenadas.getY(),50 , 50, false,true); //en el caso que ningun cubo se haya generado como destructible, fuerzo uno al final
			}
			else {
				this.cubos[x] = new Cubo(posicionCuboAnterior+50, this.coordenadas.getY(),50 , 50, false,esDestructible);
			}
			
			System.out.println("Aumentando posicion del cubo: "+posicionCuboAnterior);
			posicionCuboAnterior += 50;
			esDestructible = false;
			
		}
	}

	public Cubo[] getCubos() {
		return cubos;
	}

	public void setCubos(Cubo[] cubos) {
		this.cubos = cubos;
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	public void dibujarFilas(Entorno entorno) {
		for(int x = 0; x < cubos.length; x++) {
			//System.out.println("dibujando cubo en posiciones x: " + cubo.getX() + ", y: "+cubo.getY());
			cubos[x].dibujarCubo(entorno);
		}
	}
	
	
}
