package animacion.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import animacion.gui.PanelAnim;

public class Cuadrado {

	private int tamano;
	private int x;
	private int y;
	private PropertyChangeSupport changeSupport;
	
	public Cuadrado(int t) {
		this.tamano = t;
		x = 100;
		y = 100;
		changeSupport = new PropertyChangeSupport(this);
	}

	public int getTamano() {
		return tamano;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void ejecutarUnPasoAnimacion() {
		x += 1;
		y += 1;
		notificarCambios();
	}
	
	public void notificarCambios() {
		changeSupport.firePropertyChange("MOV", false, true);
	}

	public void addObserver(PropertyChangeListener obs) {
		changeSupport.addPropertyChangeListener(obs);
	}
}
