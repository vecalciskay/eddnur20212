package estrategia;

public class NoVuela implements IEstrategiaVuelo {

	@Override
	public void ejecutar() {
		System.out.println("No vuela (buuu)");
	}

}
