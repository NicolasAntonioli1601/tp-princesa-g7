package juego;


public class Label {
	private Coordenada coordenadas;
	private String texto;
	
	public Label(int posicionX, int posicionY, String texto) {
		this.coordenadas = new Coordenada(posicionX, posicionY);
		this.texto = texto;
	}
	
	public void dibujar() {
		
	}
	
}
