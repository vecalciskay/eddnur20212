package estrategia;

public class PatoMadera extends Pato {
	public PatoMadera() {
		estrategiaVuelo = new NoVuela();
		estrategiaCuac = new NoHabla();
	}

	@Override
	public String getTipo() {
		return "Madera";
	}
}
