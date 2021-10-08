package cadenasnaive;

public class Nodo {

	private Object contenido;
	private Nodo siguiente;
	
	public Nodo(Object o) {
		contenido = o;
		siguiente = null;
	}

	public Object getContenido() {
		return contenido;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}
}
