package hashnaive;

public class ListaHash {
    private String[] lista;
    private int tamano;

    public ListaHash(){
        lista = new String[10000];
        tamano = 0;
    }

    private void agrandar() {
        String[] nueva = new String[lista.length * 2];
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                int pos = lista[i].hashCode() % nueva.length;
                while (nueva[pos] != null) {
                    pos = (pos + 1) % nueva.length;
                }
                nueva[pos] = lista[i];
            }
        }
        lista = nueva;
    }

    public void insertar(String s) {
        int pos = s.hashCode() % lista.length;
        while (lista[pos] != null) {
            pos = (pos + 1) % lista.length;
        }
        lista[pos] = s;
        tamano++;

        if ((int)((double)tamano * 1.5) >= lista.length) {
            agrandar();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                s.append(i).append(": ").append(lista[i]).append("\n");
            }
        }
        return s.toString();
    }

    public String buscar(String s) {
        int pos = s.hashCode() % lista.length;
        while (lista[pos] != null) {
            if (lista[pos].equals(s)) {
                return lista[pos];
            }
            pos = (pos + 1) % lista.length;
        }
        return null;
    }
}
