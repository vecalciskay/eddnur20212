package arboles;

import cadenas.Cadena;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Arbol<T>  {

    private Nodo<T> raiz;

    private PropertyChangeSupport objetoCambio;

    public Arbol() {
        raiz = null;
        objetoCambio = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer) {
        objetoCambio.addPropertyChangeListener(observer);
    }

    public void insertar(T o, String id) {
        if (id == null) {
            raiz = new Nodo<T>(o);
            objetoCambio.firePropertyChange("ARBOL",true,false);
            return;
        }
        Nodo<T> padre = buscar(id);
        if (padre == null) {
            return;
        }
        padre.agregarHijo(new Nodo<T>(o));
        objetoCambio.firePropertyChange("ARBOL",true,false);
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

    public void dibujar(Graphics g, int x, int y) {
        if (raiz == null) {
            return;
        }
        raiz.dibujar(g, x, y);
    }

    static class Nodo<T> {
        private T contenido;
        private Cadena<Nodo<T>> hijos;
        private final int ANCHO_NODO = 30;
        private final int ESPACIO_HOR = 10;
        private final int ESPACIO_VER = 50;
        private boolean desplegado = false;

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

        public int getAncho() {
            if (hijos.getTamano() == 0)
                return ANCHO_NODO;

            int ancho = 0;
            int separacion = 0;
            for (Nodo<T> hijo : hijos) {
                ancho += separacion + hijo.getAncho();
                separacion += ESPACIO_HOR;
            }
            return ancho;
        }

        public void dibujar(Graphics g, int x, int y) {
            int ancho = getAncho();

            int xNodo = x + (ancho - ANCHO_NODO) / 2;
            int yNodo = y;
            int xHijo = x;
            int yHijo = y + ESPACIO_VER;

            for(Nodo<T> hijo : hijos) {
                int anchoHijo = hijo.getAncho();

                g.setColor(Color.black);
                g.drawLine(xNodo + ANCHO_NODO / 2, yNodo + ANCHO_NODO / 2,
                        xHijo + anchoHijo / 2, yHijo + ANCHO_NODO / 2);

                hijo.dibujar(g, xHijo, yHijo);
                xHijo += anchoHijo + ESPACIO_HOR;
            }

            dibujarNodo(g, xNodo, yNodo);
        }

        private void dibujarNodo(Graphics g, int x, int y) {
            g.setColor(Color.white);
            g.fillArc(x, y, ANCHO_NODO, ANCHO_NODO, 0, 360);
            g.setColor(Color.black);
            g.drawArc(x, y, ANCHO_NODO, ANCHO_NODO, 0, 360);
            g.drawString(contenido.toString(), x + 5, y + 15);
        }
    }
}
