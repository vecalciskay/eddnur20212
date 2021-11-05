package cadenas;

import java.util.Iterator;

/**
 * La cadena es una implementacion de una cadena dinamica. Tiene su propio
 * iterador e implementa <b>Generics</b> para que se pueda utilizar para cualquier
 * clase. 
 * @author Vladimir
 *
 * @param <T>
 */
public class Cadena<T> implements Iterable<T> {
	protected Nodo<T> raiz;
	protected int tamano;
	
	public Cadena() {
		tamano = 0;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public int getTamano() {
		return tamano;
	}

	public void insertar(T o) {		
		Nodo<T> nuevo = new Nodo<>(o);
		nuevo.setSiguiente(raiz);
		raiz = nuevo;
		tamano++;
	}
	
	public void adicionar(T o) {
		Nodo<T> nuevo = new Nodo<>(o);
		
		if (raiz == null) {
			raiz = nuevo;
			tamano++;
			return;
		}
		
		Nodo<T> actual = raiz;
		while(actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
		}
		
		actual.setSiguiente(nuevo);
		tamano++;
	}
	
	/**
	 * El eliminar no tira ningun error. Si se pide eliminar un objeto con indice fuera de la lista
	 * entonces no pasa nada.
	 * @param posicion
	 */
	public void eliminar(int posicion) {
		
		if (posicion >= tamano)
			return;
		
		if (posicion == 0) {
			raiz = raiz.getSiguiente();
			tamano--;
			return;
		}
		
		int numeroItem = 0; 
		Nodo<T> actual = raiz;
		while(actual != null && numeroItem < (posicion-1)) {
			actual = actual.getSiguiente();
			numeroItem++;
		}
		
		actual.setSiguiente(actual.getSiguiente().getSiguiente());
		tamano--;
	}
	
	public T get(int posicion) {
		if (posicion >= tamano)
			return null;
		
		if (posicion == 0) {
			return raiz.getContenido();
		}
		
		int numeroItem = 0; 
		Nodo<T> actual = raiz;
		while(actual != null && numeroItem < posicion) {
			actual = actual.getSiguiente();
			numeroItem++;
		}
		
		return actual.getContenido();
	}
	
	public T buscar(T id) {
		for (T o : this) {
			if (o.equals(id))
				return o;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		String sep = "";
		for(T o : this) {
			result.append(sep).append(o);
			sep = " - ";
		}
		return result.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorCadena<>(this);
	}
	
	public static class Nodo<T> {

		private T contenido;
		private Nodo<T> siguiente;
		
		public Nodo(T o) {
			contenido = o;
			siguiente = null;
		}

		public T getContenido() {
			return contenido;
		}

		public Nodo<T> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo<T> siguiente) {
			this.siguiente = siguiente;
		}
	}
	
	static class IteradorCadena<T> implements Iterator<T>{

		private Nodo<T> actual;
		
		public IteradorCadena(Cadena<T> cadena) {
			actual = cadena.getRaiz();
		}

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T obj = actual.getContenido();
			actual = actual.getSiguiente();
			return obj;
		}
		
	}

}
