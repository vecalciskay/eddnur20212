package arboles;

import cadenas.Cadena;

public class Arbol<T> {

    private Nodo<T> raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(T o, String id) {
        if (id == null) {
            raiz = new Nodo<T>(o);
            return;
        }
        Nodo<T> padre = buscar(id);
        if (padre == null) {
            return;
        }
        padre.agregarHijo(new Nodo<T>(o));
    }

    @Override
    public String toString() {
        return raiz.toString();
    }

    public Nodo<T> buscar(String id) {
        if (id == null) {
            return null;
        }
        Nodo<T> padre = raiz.buscar(id);
        return padre;
    }

    static class Nodo<T> {
        private T contenido;
        private Cadena<Nodo<T>> hijos;

        public Nodo(T contenido) {
            this.contenido = contenido;
            this.hijos = new Cadena<>();
        }

        public Nodo<T> buscar(String id) {

            if (((ObjetoIdentificable)contenido).getId().equals(id)) {
                return this;
            }
            for (Nodo<T> hijo : hijos) {
                Nodo<T> encontrado = hijo.buscar(id);
                if (encontrado != null)
                    return encontrado;
            }
            return null;
        }

        public void agregarHijo(Nodo<T> hijo) {
            hijos.insertar(hijo);
        }

        @Override
        public String toString() {
            if (hijos.getTamano() == 0)
                return contenido.toString();

            StringBuilder sb = new StringBuilder();
            sb.append(contenido.toString());
            sb.append("(");
            String separador = "";
            for (Nodo<T> hijo : hijos) {
                sb.append(separador).append(hijo.toString());
                separador = ",";
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
