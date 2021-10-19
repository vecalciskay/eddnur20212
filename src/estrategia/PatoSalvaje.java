package estrategia;

public class PatoSalvaje extends Pato {

	public PatoSalvaje() {
		estrategiaVuelo = new SiVuela();
		estrategiaCuac = new HaceCuac();
	}

	@Override
	public String getTipo() {
		return "Salvaje";
	}
}
