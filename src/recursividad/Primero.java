package recursividad;

public class Primero {
	public static void main(String[] args) {
		imprimirHola(10);
		
		System.out.println("suma de 10 = " + suma(10));
	}

	public static void imprimirHola(int n) {
		if (n == 0)
			return;

		imprimirHola(n - 1);
		System.out.println("Hola " + n);
	}
	
	public static int suma(int n) {
		if (n == 1)
			return 1;
		
		return n + suma(n-1);
	}
}
