package eddnur20212.hello;

public class HolaSuma {

	public int sumar(int x, int y) {
		return x+y;
	}
	
	public static void main(String[] args) {
		
		HolaSuma suma = new HolaSuma();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(suma.sumar(i, i));
		}
	}
}
