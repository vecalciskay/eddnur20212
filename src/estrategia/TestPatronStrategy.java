package estrategia;

import cadenas.Cadena;

public class TestPatronStrategy {

	public static void main(String[] args) {
		
		Cadena<Pato> c = new Cadena<>();
		
		PatoSalvaje p = new PatoSalvaje();
		c.insertar(p);
		
		PatoMadera pm = new PatoMadera();
		c.insertar(pm);
		
		for (Pato pato : c) {
			System.out.println(pato.getTipo());
			pato.vuela();
			pato.cuac();
		}
	}
}
