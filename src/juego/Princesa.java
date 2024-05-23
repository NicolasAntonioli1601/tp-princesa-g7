package juego;

import java.awt.Image;
import java.util.List;

import entorno.Entorno;
import entorno.Herramientas;

public class Princesa {
	private Coordenada coordenadas;
	double ancho;
	double altura;
	Image img1;
	private Entorno entorno;
	private Cubo cubo;
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
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(img1, this.getCoordenadas().getX(), this.getCoordenadas().getY(), 0, 0.3);
	}

	public void moverDerecha() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.getCoordenadas().getX() <= 750) {
			this.getCoordenadas().moverXCantidad(true, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-der.png");
		}
	}

	public void moverIzquierda() {
		if (this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.getCoordenadas().getX() >= 50) {
			this.getCoordenadas().moverXCantidad(false, 3);
			this.img1 = Herramientas.cargarImagen("recursos/princesa-izq.png");

		}
	}

	public void saltar() {
		char a = 'x';
		if (this.entorno.estaPresionada(a) && this.getCoordenadas().getY() >= 50) {
			this.img1 = Herramientas.cargarImagen("recursos/princesa-salto.png");
			this.getCoordenadas().moverYCantidad(true, 30);

		}
	}

	public boolean sobreFila() {
		if (this.getCoordenadas().getY() == 400 || this.getCoordenadas().getY() == 250
				|| (this.getCoordenadas().getY() == 95)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sobreCubo(List<Cubo> nombre) {
		for (int i = 0; i < nombre.size(); i++) {
			if (nombre.get(i).getX() == this.getCoordenadas().getX()) {
				return false;
			}
		}
		return true;
	}

	public void dispara() {

		this.tiro = new Tiro(this.coordenadas.getX() - 20, this.coordenadas.getY());
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
}
