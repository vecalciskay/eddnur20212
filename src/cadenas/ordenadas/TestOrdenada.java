package cadenas.ordenadas;

import cadenas.Cadena;

public class TestOrdenada {

	public static void main(String[] args) {
		CadenaOrdenada<String> a = new CadenaOrdenada<>();
		
		a.insertar("Hugo");
		a.insertar("Paco");
		a.insertar("Luis");
		a.insertar("Maria");
		a.insertar("Daniel");
		a.insertar("Lorena");
		a.insertar("Ivan");
				
		System.out.println(a);
		
		String b = a.buscar("Luisa");
		
		System.out.println("Encontro: " + (b == null ? "NADA" : b));
	}
}
