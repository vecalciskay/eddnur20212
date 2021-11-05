package cadenas.ordenadas;

import cadenas.Cadena;

public class CadenaOrdenada<T> extends Cadena<T> {

	public CadenaOrdenada() {
		super();
	}

	@Override
	public void insertar(T o) {
		if (!(o instanceof Comparable)) {
			super.insertar(o);
			return;
		}
		if (raiz == null) {
			super.insertar(o);
			return;
		}

		Cadena.Nodo<T> actual = raiz;
		if (((Comparable) actual.getContenido()).compareTo(o) > 0) {
			super.insertar(o);
			return;
		}
		
		while(actual.getSiguiente() != null && ((Comparable)actual.getSiguiente().getContenido()).compareTo(o) < 0) {
			actual = actual.getSiguiente();
		}
		
		Cadena.Nodo<T> nuevo = new Cadena.Nodo<>(o);
		nuevo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevo);
		tamano++;
	}
	
	@Override
	public T buscar(T id) {
		if (!(id instanceof Comparable)) {
			return super.buscar(id);
		}
		
		return busquedaDicotomica(id, 0, tamano-1);
	}

	private T busquedaDicotomica(T id, int idxInicio, int idxFinal) {

		if (idxFinal - idxInicio <= 1) {
			T encontrado = get(idxFinal);
			if (encontrado.equals(id)) { // encontrado.getCi().equals(id.getId())
				return encontrado;
			}
			encontrado = get(idxInicio);
			if (encontrado.equals(id)) {
				return encontrado;
			}
			return null;
		}
		
		int idxMedio = idxInicio + (idxFinal - idxInicio) / 2;
		// Buscar el del medio
		T medio = get(idxMedio);
		if (medio.equals(id))
			return medio;
		
		int resultadoComparacion = ((Comparable<T>)id).compareTo(medio);
		if (resultadoComparacion < 0) 
			return busquedaDicotomica(id, idxInicio, idxMedio);
		else
			return busquedaDicotomica(id, idxMedio, idxFinal);
	}
}
