package arboles;

public class Animal implements ObjetoIdentificable {
    private String nombre;
    private int numeroPatas;
    private boolean tieneCola;
    protected String id;


    public String getId(){
        return id;
    }
    public Animal(String id, String nombre, int numeroPatas, boolean tieneCola) {
        this.id = id;
        this.nombre = nombre;
        this.numeroPatas = numeroPatas;
        this.tieneCola = tieneCola;
    }

    @Override
    public String toString() {
        return nombre + '|' + numeroPatas;
    }
}
