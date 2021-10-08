package animacion.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import animacion.model.Cuadrado;

public class PanelAnim extends JPanel implements PropertyChangeListener {

	private Cuadrado modelo;
	
	public PanelAnim(Cuadrado c) {
		modelo = c;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (modelo != null) {
			g.fillRect(modelo.getX(), modelo.getY(), modelo.getTamano(), modelo.getTamano());
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}
