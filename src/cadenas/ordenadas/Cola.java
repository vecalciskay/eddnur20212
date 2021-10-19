package cadenas.ordenadas;

import cadenas.Cadena;

public class Cola<T> extends Cadena<T> implements ICola<T> {
	
	public static int MAX_SIZE = 10000;
	
	public Cola() {
		super();
	}

	@Override
	public void push(T o) {
		this.adicionar(o);
	}

	@Override
	public T pull() {
		T top = get(0);
		eliminar(0);
		return top;
	}

	@Override
	public T peek() {
		return get(0);
	}

	@Override
	public boolean isEmpty() {
		// return raiz == null;
		return tamano == 0;
	}

	@Override
	public boolean isFull() {
		return tamano >= MAX_SIZE;
	}
	
}
