package paint.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import paint.modelo.Imagen;

public class PaintPanel extends JPanel implements PropertyChangeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Imagen modelo;
	public PaintPanel() {
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (modelo == null)
			return;
		
		BufferedImage rsm = new BufferedImage(modelo.getAncho(), modelo.getAlto(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rsm.createGraphics();
		
		for (int j = 0; j < modelo.getAlto(); j++) {
			for (int i = 0; i < modelo.getAncho(); i++) {
				g2d.setColor(modelo.getColor(i,j));
				g2d.drawLine(i, j, i, j);
			}	
		}
		
		g.drawImage(rsm, 0, 0, null);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		modelo = (Imagen)evt.getSource();
		repaint();
	}
}
