package hashnaive;

public class Persona {

    private String nombre;
    private Carnet carnet;

    public Persona(String nombre, Carnet carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", carnet=" + carnet +
                '}';
    }
}
