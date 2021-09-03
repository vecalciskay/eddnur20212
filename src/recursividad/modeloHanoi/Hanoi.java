package recursividad.modeloHanoi;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Hanoi {

	private Torre[] torres;
	private int cantMovimientos;
	private int cantidadAros;
	private PropertyChangeSupport cambios;
	
	public Hanoi(int n) {
		torres = new Torre[3];
		for (int i = 0; i < torres.length; i++) {
			torres[i] = new Torre();
		}
		cantidadAros = n;
		
		cambios = new PropertyChangeSupport(this);
	}
	
	public void mover(int de, int a) {
		torres[a].poner( torres[de].quitar());
		this.cambios.firePropertyChange("MOV", true, false);
	}
	
	public void resolver(int de, int a, int pp) {
		// Tareas a hacer antes de resolver
		for (int i = 0; i < torres.length; i++) {
			torres[i].vaciar();
		}
		
		for (int i = 0; i < cantidadAros; i++) {
			Aro aro = new Aro( cantidadAros - i);
			torres[de].poner(aro);
		}
		
		this.cambios.firePropertyChange("RESET", true, false);
		
		this.resolverRecursivo(de, a, pp, cantidadAros);
	}
	
	public void resolverRecursivo(int de, int a, int pp, int n) {
		if (n == 1) {
			cantMovimientos++;
			mover(de, a);
			return;
		}
		
		resolverRecursivo(de, pp, a, n - 1);
		resolverRecursivo(de, a, pp, 1);
		resolverRecursivo(pp, a, de, n - 1);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < torres.length; i++) {
			result.append(torres[i]).append("\n");
		}
		result.append("\n");
		
		return result.toString();
	}

	public void addObserver(PropertyChangeListener escuchador) {
		cambios.addPropertyChangeListener(escuchador);		
	}
}
