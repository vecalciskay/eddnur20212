package hashnaive;

public class TestListaHash {
    public static void main(String[] args) {
        ListaHash h = new ListaHash();

        h.insertar("Hugo");
        h.insertar("Paco");
        h.insertar("Luis");

        System.out.println(h);

        String encontrado = h.buscar("Hugo");

        System.out.println(encontrado);
    }
}
