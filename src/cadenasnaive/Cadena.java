package cadenasnaive;

public class Cadena {

	private Nodo raiz;
	private int tamano;
	
	public Cadena() {
		tamano = 0;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public int getTamano() {
		return tamano;
	}

	public void insertar(Object o) {
		
		Nodo nuevo = new Nodo(o);
		nuevo.setSiguiente(raiz);
		raiz = nuevo;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		Nodo actual = raiz;
		String sep = " - ";
		while(actual != null) {
			result.append(sep).append(actual.getContenido());
			actual = actual.getSiguiente();
		}
		
		return result.toString();
	}
}
