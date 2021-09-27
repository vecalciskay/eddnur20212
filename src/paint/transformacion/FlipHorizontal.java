package paint.transformacion;

import paint.modelo.Imagen;

public class FlipHorizontal extends Transformacion {
	
	public FlipHorizontal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Img: 
	 * (30, 40, 10, 0, 50, 80)
	 * (30, 40, 10, 90, 30, 80)
	 * (40, 70, 10, 90, 20, 80)
	 * (90, 70, 10, 90, 30, 80)
	 * 
	 * Flip
	 * (80, 50, 0, 10, 40, 30)
	 * (80, 30, 90, 10, 40, 30)
	 * (80, 20, 90, 10, 70, 40)
	 * (80, 30, 90, 10, 70, 90)
	 * 
	 * @param modelo
	 */
	public void transformar(Imagen modelo) {
		int ancho = modelo.getAncho();
		int alto = modelo.getAlto();
		Imagen nuevaImagen = new Imagen(ancho, alto);
		
		for (int j = 0; j < modelo.getAlto(); j++) {
			for (int i = 0; i < modelo.getAncho(); i++) {
				nuevaImagen.getPixeles()[i][j] = modelo.getPixeles()[ancho - i - 1][j];
			}
		}
		
		for (int j = 0; j < modelo.getAlto(); j++) {
			for (int i = 0; i < modelo.getAncho(); i++) {
				modelo.getPixeles()[i][j] = nuevaImagen.getPixeles()[i][j];
			}
		}
		
		modelo.imagenCambiada();
	}
}
