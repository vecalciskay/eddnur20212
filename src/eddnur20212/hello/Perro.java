package eddnur20212.hello;

public class Perro extends Animal {

	public Perro(String nombre) {
		this.setNombre(nombre);
	}

	@Override
	public void caminar() {
		System.out.println("De 4 patas");
	}
	
}
