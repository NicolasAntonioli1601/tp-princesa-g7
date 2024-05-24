package juego;

import java.awt.Image;
import java.util.List;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	private Entorno entorno;
	boolean posicionDerecha;
	Image img1;
	Tiro tiro;
	

	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public Princesa(int posicionX, int posicionY, double ancho, double altura) {
		this.setCoordenadas(new Coordenada(posicionX, posicionY));
		this.img1 = Herramientas.cargarImagen("recursos/princesa-frent.png");
		this.ancho = ancho;
		this.altura = altura;
		this.posicionDerecha=false;
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.getCoordenadas().getX(), this.getCoordenadas().getY(), 0, 0.3);
	}

	public void moverDerecha() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.getCoordenadas().getX() <= 750) {
			this.getCoordenadas().moverXCantidad(true, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-der.png");
			this.posicionDerecha=true;
		}
	}

	public void moverIzquierda() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.getCoordenadas().getX() >= 50) {
			this.getCoordenadas().moverXCantidad(false, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-izq.png");
			this.posicionDerecha=false;
		}
		
		
	}

	public void saltar() {
		char a = 'x';
		if (this.entorno.estaPresionada(a) && this.getCoordenadas().getY() >= 50) {
			this.img1 = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().moverYCantidad(true, 30);

		}
	}


	public void dispara() {

		this.tiro = new Tiro(this.coordenadas.getX() - 20, this.coordenadas.getY(), this.posicionDerecha);
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	public boolean sobreFila() {
		if (this.getCoordenadas().getY() == 400 || this.getCoordenadas().getY() == 250
				|| (this.getCoordenadas().getY() == 95)) {
			return true;
		} else {
			return false;
		}
	}
}
