package cadenas;

import java.util.Iterator;

public class EjemploCadena {

	public static void main(String[] args) {
		Cadena<String> a = new Cadena<>();
		
		a.insertar("Hugo");
		a.insertar("Paco");
		a.insertar("Luis");
		a.adicionar("Maria");
		
		/*
		imprimirConIterador(a);
				
		imprimirConFor(a);*/
		
		System.out.println(a);
		
		a.eliminar(2);

		System.out.println(a);
	}

	private static void imprimirConFor(Cadena<String> a) {
		for(String s : a)
			System.out.println("Contenido FOR: " + s);
	}

	private static void imprimirConIterador(Cadena<String> a) {
		Iterator<String> iterator  = a.iterator();
		while(iterator.hasNext()) {
			String s = iterator.next();
			System.out.println("Contenido: " + s);
		}
	}
	
}