package estrategia;

public abstract class Pato {

	protected IEstrategiaVuelo estrategiaVuelo;
	protected IEstrategiaCuac estrategiaCuac;
	
	public abstract String getTipo();
	
	public void vuela() {
		estrategiaVuelo.ejecutar();
	}
	
	public void cuac() {
		estrategiaCuac.ejecutar();
	}
}
