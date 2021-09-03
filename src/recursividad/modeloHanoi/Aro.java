package recursividad.modeloHanoi;

public class Aro {
	private int tamano;

	public Aro(int t) {
		tamano = t;
	}

	public int getTamano() {
		return tamano;
	}
	
	@Override
	public String toString() {
		return String.valueOf(tamano);
	}
}
