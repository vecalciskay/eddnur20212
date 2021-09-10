package recursividad.mandelbrot.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import recursividad.mandelbrot.modelo.Mandelbrot;

public class MandelbrotFrame extends JFrame {

	public static void main(String[] args) {
		new MandelbrotFrame();
	}
	public MandelbrotFrame() {
		inicializar();
		this.setVisible(true);
	}
	
	public void inicializar() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		Mandelbrot mandelbrot = new Mandelbrot(1000, 800);
		MandelbrotPanel pnlMandelbrotPanel = new MandelbrotPanel(mandelbrot.getImagen());
		this.getContentPane().add(pnlMandelbrotPanel, BorderLayout.CENTER);
		
		this.pack();
	}
}
