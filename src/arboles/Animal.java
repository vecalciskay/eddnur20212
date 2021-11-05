package arboles;

public class Animal extends ObjetoIdentificable {
    private String nombre;
    private int numeroPatas;
    private boolean tieneCola;

    public Animal(String id, String nombre, int numeroPatas, boolean tieneCola) {
        super(id);
        this.nombre = nombre;
        this.numeroPatas = numeroPatas;
        this.tieneCola = tieneCola;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", numeroPatas=" + numeroPatas +
                ", tieneCola=" + tieneCola +
                '}';
    }
}
