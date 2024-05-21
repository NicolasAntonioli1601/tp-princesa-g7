package juego;

public class Coordenada {
	private int x;
	private int y;
	
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void moverX(boolean sentido) {
		//recibe un booleano para mover el objeto en sentido horizontal, 
		//si es true, mueve a la derecha, si es false mueve a la izquierda 
		if (sentido) {
			this.x ++;
		}
		else{
			this.x --;
		}
	}
	
	public void moverY(boolean sentido) {
		//recibe un booleano para mover el objeto en sentido vertical, 
		//si es true, mueve para arriba, si es false mueve para abajo
		if (sentido) {
			this.y --;
		}
		else{
			this.y ++;
		}
	}
	
	public void moverXCantidad(boolean sentido, int cantidad) {
		//recibe un booleano para mover el objeto en sentido horizontal, 
		//si es true, mueve a la derecha, si es false mueve a la izquierda 
		if (sentido) {
			this.x += cantidad;
		}
		else{
			this.x -= cantidad;
		}
	}
	
	public void moverYCantidad(boolean sentido, int cantidad) {
		//recibe un booleano para mover el objeto en sentido vertical, y la cantidad de pixeles que se quiere mover 
		//si es true, mueve para arriba, si es false mueve para abajo
		if (sentido) {
			this.y -= cantidad;
		}
		else{
			this.y += cantidad;
		}
	}
}
