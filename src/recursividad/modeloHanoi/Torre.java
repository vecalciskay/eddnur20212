package recursividad.modeloHanoi;

import java.util.Stack;

public class Torre {

	private Stack<Aro> aros;
	
	public Torre() {
		aros = new Stack<>();
	}
	
	public void poner(Aro a) {
		aros.push(a);
	}
	
	public Aro quitar() {
		return aros.pop();
	}

	public void vaciar() {
		aros.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("|-");
		
		for (Aro aro : aros) {
			result.append(aro).append("-");
		}
		
		return result.toString();
	}
}
