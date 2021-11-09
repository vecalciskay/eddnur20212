package arboles.gui;

import arboles.Animal;
import arboles.Arbol;
import paint.gui.PaintPanel;
import paint.modelo.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FrameArbol extends JFrame implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private Arbol<Animal> modelo;
    private JLabel lblArbol;

    public FrameArbol() {
        super("Arbol");
        inicializar();
    }

    public static void main(String[] args) {
        FrameArbol frame = new FrameArbol();
        frame.setVisible(true);
    }

    public void inicializar() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar jmb = new JMenuBar();

        // --------------MENU ARCHIVO
        JMenu archivo = new JMenu("Archivo");

        JMenuItem menuItem = new JMenuItem("Dibujar");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                archivo_Dibujar();
            }
        });
        archivo.add(menuItem);

        jmb.add(archivo);

        this.setJMenuBar(jmb);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Arbol<>();
        PanelArbol pnl = new PanelArbol(modelo);
        modelo.addObserver(pnl);
        modelo.addObserver(this);
        this.getContentPane().add(pnl, BorderLayout.CENTER);

        lblArbol = new JLabel();
        this.getContentPane().add(lblArbol, BorderLayout.SOUTH);
        this.pack();
    }

    private void archivo_Dibujar() {
        Animal perro1 = new Animal("A","A",4,true);
        modelo.insertar(perro1, null);

        Animal gato1 = new Animal("B","B",3,true);
        modelo.insertar(gato1, perro1.getId());

        Animal gato2 = new Animal("C","C",4,true);
        modelo.insertar(gato2, perro1.getId());

        Animal gato3 = new Animal("D","D",4,true);
        modelo.insertar(gato3, perro1.getId());

        Animal rat1 = new Animal("E","E",4,true);
        modelo.insertar(rat1, gato3.getId());

        Animal rat2 = new Animal("F","F",4,true);
        modelo.insertar(rat2, gato3.getId());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        lblArbol.setText(modelo.toString());
    }
}
