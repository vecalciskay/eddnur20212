package recursividad;

public class HanoiTrucho {
	
	private int cantMovimientos;

	public static void main(String[] args) {
		HanoiTrucho ht = new HanoiTrucho();
		
		ht.hanoi(1, 3, 2, 4);
	}
	
	public HanoiTrucho() {
		cantMovimientos = 0;
	}
	
	public void hanoi(int de, int a, int pp, int n) {
		
		if (n == 1) {
			cantMovimientos++;
			System.out.println("Mov " + cantMovimientos + ": " + de + "  -->  " + a);
			return;
		}
		
		hanoi(de, pp, a, n - 1);
		hanoi(de, a, pp, 1);
		hanoi(pp, a, de, n - 1);
	}
}
