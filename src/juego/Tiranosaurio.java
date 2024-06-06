package juego;

import java.awt.Image;
import java.awt.Color;
import entorno.Entorno;
import entorno.Herramientas;


public class Tiranosaurio {
	
	private Coordenada coordenadas;
	private int x;
	private int y;
	private double alto;
	private double ancho;
	
	private double gravedad;
	private double piso;
	
	private Entorno entorno;
	
	private String direccion;
	private String estado;
	private int contadorSprite;
	
    private Image imgIzq;
    private Image imgDer;
    private Image imgIzqMov;
    private Image imgDerMov;
    private Image imgIzqDisparo;
    private Image imgDerDisparo;
    
	
	//constructor Tiranosaurio
    public Tiranosaurio(int x, int y, double alto, double ancho, Entorno entorno) {
    	this.coordenadas = new Coordenada(x, y);
    	this.alto = alto;
    	this.ancho = ancho;
    	this.entorno = entorno;
    	
    	this.gravedad = 0.5;
    	this.piso = this.y + this.alto/2;
    	
    	this.direccion = "Derecha";
    	this.direccion = "Izquierda";
    	this.estado = "Moviendose";
    	this.contadorSprite = 0;
    	
    }
    
    
    //Movimientos
    public void moverDerecha() {
    	while(this.getCoordenada().getX() < 400) {
    		this.getCoordenada().moverXCantidad(true,5 );
    	}
    	
   
     }
    
    public void moverIzquierda() {
    	while(this.getCoordenada().getY() > 0) {
    		this.getCoordenada().moverXCantidad(true,5 );
    	}
     }
    
    
    public void estatico() {
    	this.estado = "Quieto";
    }
    
    
    
    public void cargarImagen() {
    	
    	this.imgIzq = Herramientas.cargarImagen("DinoIzq.png");
    	this.imgDer = Herramientas.cargarImagen("DinoIzq.png");
    	this.imgIzqMov = Herramientas.cargarImagen("DinoIzq.png");
    	this.imgDerMov = Herramientas.cargarImagen("DinoIzq.png");
    	this.imgIzqDisparo = Herramientas.cargarImagen("DinoIzq.png");
    	this.imgDerDisparo = Herramientas.cargarImagen("DinoIzq.png");
    }
    
    public void dibujarT(Entorno entorno, Image img, double x, double y) {
    	
    	entorno.dibujarImagen(img, this.getCoordenada().getX(), this.getCoordenada().getY(), 0);
    }
    
    
    public void disparar() {
    	
    	
    }
    
    
    public Coordenada setCoordenada(Coordenada coordenadas) {
    	return this.coordenadas;
    }
    
    public Coordenada getCoordenada() {
    	return coordenadas;
    }
    
	public Entorno getEntorno() {
		return entorno;
	}
	
	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}
	

	

}
