package paint.modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagen {
	private int[][] pixeles;
	private int ancho;
	private int alto;
	private PropertyChangeSupport changes;
	
	public Imagen(int w, int h) {
		this.ancho = w;
		this.alto = h;
		pixeles = new int[ancho][alto];
		changes = new PropertyChangeSupport(this);
	}
	
	public void addObserver(PropertyChangeListener observer) {
		changes.addPropertyChangeListener(observer);
	}

	public Imagen(String rutaArchivo) {
		
		this(600,400);
		
		BufferedImage bi = null;
		try {
			File f = new File(rutaArchivo);
			bi = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setImagen(bi);
	}
	
	public void imagenCambiada() {
		changes.firePropertyChange("imagen", true, false);
	}
	
	public void setImagen(BufferedImage img) {
		ancho = img.getWidth();
		alto = img.getHeight();
		pixeles = new int[ancho][alto];
		
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				pixeles[i][j] = img.getRGB(i, j);
			}
		}
		
		changes.firePropertyChange("imagen", true, false);
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

	public void setColor(int i, int j, int n) {
		pixeles[i][j] = n;
	}

	public Color getColor(int x, int y) {
		int c = pixeles[x][y];
		return new Color(c);
	}
}
