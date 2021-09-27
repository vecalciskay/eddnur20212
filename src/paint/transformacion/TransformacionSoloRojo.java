package paint.transformacion;

import java.awt.Color;

import paint.modelo.Imagen;

public class TransformacionSoloRojo extends Transformacion {

	public TransformacionSoloRojo() {
		
	}
	
	public void transformar(Imagen modelo) {
		for (int j = 0; j < modelo.getAlto(); j++) {
			for (int i = 0; i < modelo.getAncho(); i++) {
				Color c = modelo.getColor(i, j);
				Color soloRojo = new Color(c.getRed(), 0, 0);
				modelo.setColor(i, j, soloRojo.getRGB());
			}
		}
		
		modelo.imagenCambiada();
	}
}
