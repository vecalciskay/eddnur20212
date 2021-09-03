package recursividad.modeloHanoi;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VeedorHanoiConsola implements PropertyChangeListener {

	private Hanoi modelo;
	
	public VeedorHanoiConsola(Hanoi m) {
		modelo = m;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(modelo);
	}
}
