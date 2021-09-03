package recursividad.modeloHanoi;

public class HanoiPrincipal {

	public static void main(String[] args) {
		Hanoi h = new Hanoi(3);
		VeedorHanoiConsola veedor = new VeedorHanoiConsola(h); 
		
		h.addObserver(veedor);
		
		h.resolver(0, 2, 1);
	}
}
