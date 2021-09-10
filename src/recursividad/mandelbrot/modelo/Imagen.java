package recursividad.mandelbrot.modelo;

import java.awt.Color;

public class Imagen {

	private int[][] pixeles;
	private int ancho;
	private int alto;
	
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	
	public Imagen(int w, int h) {
		this.ancho = w;
		this.alto = h;
		pixeles = new int[ancho][alto];
		
		minX = -1.5;
		minY = -1.0;
		maxX = 0.75;
		maxY = 1.0;
	}

	public int[][] getPixeles() {
		return pixeles;
	}

	public void setPixeles(int[][] pixeles) {
		this.pixeles = pixeles;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public NumeroComplejo getPuntoComplejo(int x, int y) {
		// Regla de 3 simple para los X
		
		double xratio = (double)x / (double)ancho;
		double distX = (maxX - minX);
		double cx = minX + (xratio * distX);
		
		double yratio = (double)y / (double)alto;
		double distY = (maxY - minY);
		double cy = minY + (yratio * distY);
		
		return new NumeroComplejo(cx, cy);
	}

	public void setColor(int i, int j, int n) {
		pixeles[i][j] = n;
	}

	public Color getColor(int x, int y) {
		int c = pixeles[x][y];
		return new Color(c, c, c);
	}
}
