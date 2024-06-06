package juego;

import java.awt.Image;
import java.util.List;
import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;

public class Cubo {
	private double y;
	private double x;
	private int altura;
	private int ancho;
	private boolean estado;
	private boolean esRompible;
	Image imgCubo, imgcubo2, Ladrillo;
	Random random = new Random();

	public Cubo(double x, double y, int altura, int ancho, boolean estado, boolean tipo) {
		this.y = y;
		this.x = x;
		this.altura = altura;
		this.ancho = ancho;
		this.estado = estado;
		this.esRompible = tipo;
		this.estado = true;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public boolean isRompible() {
		return esRompible;
	}

	public void setRompible(boolean tipo) {
		this.esRompible = tipo;
	}

	public void ListaAgregar(double[] listaFijo, double[] listaRandom) {
		int cubo1 = random.nextInt(15);
		int cubo2 = random.nextInt(15);
		int cubo3 = random.nextInt(15);
		int cubo4 = random.nextInt(15);
		int posicionX = 25;
		int contador = 0;
		int contadorListaRandom = 0;
		while (contador <= 15) {
			if (cubo1 == contador || cubo2 == contador || cubo3 == contador || cubo4 == contador) {
				listaRandom[contador] = posicionX;
//			System.out.println("listaRandom");
//			System.out.println(listaRandom[contador]);
				posicionX = posicionX + 50;
				contador++;
				contadorListaRandom++;
			} else {
				listaFijo[contador] = posicionX;
				// System.out.println("listaFijo");
				// System.out.println(listaFijo[contador]);
				posicionX = posicionX + 50;
				contador++;
			}

		}
		System.out.println(contadorListaRandom);
		double[] ListaRandomNew = new double[contadorListaRandom];
		int cont = 0;
		for (int i = 0; i < listaRandom.length; i++) {
			if (listaRandom[i] != 0.0) {
				ListaRandomNew[cont] = listaRandom[i];
				cont++;
			}
		}
		listaRandom = ListaRandomNew;

	}

	public void DibujarCubos(Entorno e, double[] listaFijo, double[] ListaRandom, double y) {
		double a = 0.0;
		for (int ejex = 0; ejex < listaFijo.length; ejex++) {
			if (listaFijo[ejex] != a) {
				Cubo cubo = new Cubo(listaFijo[ejex], y, 50, 50, false, true);
				cubo.DibujarCuboFijo(e, ejex, y, 50, 50);
			}
		}
		for (int ejex = 0; ejex < ListaRandom.length; ejex++) {
			if (ListaRandom[ejex] != a) {
				// System.out.println(ListaRandom[ejex]);
				Cubo cubo = new Cubo(ListaRandom[ejex], y, 50, 50, false, false);
				cubo.DibujarCuboRomp(e, ListaRandom[ejex], y, 50, 50);
			}
		}
	}

	public void DibujarCuboFijo(Entorno e, double x, double y, int ancho, int altura) {
		imgCubo = Herramientas.cargarImagen("cubo fijo.png");
		e.dibujarImagen(imgCubo, this.x, this.y, 0, 0.3);
	}

	public void DibujarCuboRomp(Entorno e, double x, double y, int ancho, int altura) {
		imgcubo2 = Herramientas.cargarImagen("cuadrado.png");
		e.dibujarImagen(imgcubo2, this.x, this.y, 0, 0.1);
	}

	public void Colision(Princesa princesa, double ListaFijo[], double listaRandom[],int y) {

		for (int ejex = 0; ejex < listaRandom.length; ejex++) {
			
			if ((princesa.getCoordenadas().getX() - listaRandom[ejex])
					* (princesa.getCoordenadas().getX() - listaRandom[ejex])
					+ (princesa.getCoordenadas().getY() - y) * (princesa.getCoordenadas().getY() - y) <30* 30) {
				System.out.println("colision");
				listaRandom[ejex] = 0.0;
					
				}
//			if(listaRandom[ejex]== 0.0 && princesa.getCoordenadas().getY() ==400) {
//				princesa.getCoordenadas().setY(550);
//				princesa.getCoordenadas().moverYCantidad(false, 5);
//			}
//			
		}
		for (int ejex = 0; ejex < ListaFijo.length; ejex++) {
			if ((princesa.getCoordenadas().getX() - ListaFijo[ejex])
					* (princesa.getCoordenadas().getX() - ListaFijo[ejex])
					+ (princesa.getCoordenadas().getY() - y) * (princesa.getCoordenadas().getY() - y) < 45* 45 ){
						princesa.getCoordenadas().setY(y-50);	
						
			}	
			
		}
	}

	public boolean colision1(double x1, double y1, double x2, double y2, double dist) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < dist * dist;
	}

	public void BorrarCubo(Princesa princesa, double listaRandom[]) {
		for (int ejex = 0; ejex < listaRandom.length; ejex++) {
			if (colision1(princesa.getCoordenadas().getX(), princesa.getCoordenadas().getY(), listaRandom[ejex], 450,
					60) == true) {

			}

		}
	}
	
	public void dibujarCubo(Entorno entorno) {
		if(this.estado) {
			if(this.esRompible) {
				imgcubo2 = Herramientas.cargarImagen("cuadrado.png");
				entorno.dibujarImagen(imgcubo2, this.x, this.y, 0, 0.1);
			}
			else {
				imgCubo = Herramientas.cargarImagen("cubo fijo.png");
				entorno.dibujarImagen(imgCubo, this.x, this.y, 0, 0.3);
			}
		}
	}
	
	public boolean colisionaConPrincesa(Princesa princesa) {
		return colision1(this.x, this.y, princesa.getX(), princesa.getY(), 25);
	}
	
	//public void CuboDestruido (double x,double y,Entorno e) {
		//Cubo Ladrillo1;
		//Cubo Ladrillo2;
		//Ladrillo1 = new Cubo(x,y,25,10, true, true);
		//Ladrillo2 = new Cubo(x,y,25,10, true, true);
		
		//Ladrillo1.DibujarLadrillo(e, x+30, y+50, 25,10);
		//Ladrillo2.DibujarLadrillo(e, x+30, y+45, 25,10);
		
	//}
	public boolean cuboVacio(List<Cubo> nombre) {
		for (int i=0; i<nombre.size();i++) {
			if (nombre.get(i)==null) {
				return true;
			}
		}
		return false;
	}
}
