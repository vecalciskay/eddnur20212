package arboles.gui;

import arboles.Animal;
import arboles.Arbol;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelArbol extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private Arbol<Animal> modelo;

    public PanelArbol(Arbol<Animal> modelo) {
        this.modelo = modelo;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null)
            modelo.dibujar(g, 10, 10);
    }
}
