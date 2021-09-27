package paint.transformacion;

import java.awt.Color;

import paint.modelo.Imagen;

public class TonosDeGris extends Transformacion {
	
	public TonosDeGris() {
		
	}
	
	
	/**
	 * Colores: (34,67,100), (100,200,100), (0, 50, 255)
	 * Transformados a gris (R == G == B):
	 * Colores: (
	 */
	public void transformar(Imagen modelo) {
		for (int j = 0; j < modelo.getAlto(); j++) {
			for (int i = 0; i < modelo.getAncho(); i++) {
				Color c = modelo.getColor(i, j);
				/*
				int gris = c.getGreen() - 1;
				if (gris < 0) 
					gris = 0;
				*/
				
				int gris = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				Color tonoGris = new Color(gris, gris, gris);
				modelo.setColor(i, j, tonoGris.getRGB());
			}
		}
		
		modelo.imagenCambiada();
	}
}
