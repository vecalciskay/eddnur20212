package eddnur20212.hello;

public class Gato extends Animal {

	public Gato(String nombre) {
		setNombre(nombre);
	}

	@Override
	public void caminar() {
		System.out.println("De 4 patas, pero sin hacer ruido");
	}
}
