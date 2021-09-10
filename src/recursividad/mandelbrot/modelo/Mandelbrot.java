package recursividad.mandelbrot.modelo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mandelbrot {

	private Imagen modelo;
	private static Logger log = LogManager.getRootLogger();
	
	public Mandelbrot(int w, int h) {
		modelo = new Imagen(w, h);
		calcular();
	}

	private void calcular() {
		for(int j=0; j<modelo.getAlto(); j++) {
			for(int i=0; i<modelo.getAncho(); i++) {
				
				int n = convergeMandelbrot(modelo.getPuntoComplejo(i, j));
				modelo.setColor(i, j, n);
				//log.debug("(" + i + " , "  + j + ") = " + n);
			}
		}
	}

	private int convergeMandelbrot(NumeroComplejo z0) {
		int n = 0;
		boolean convergente = true;
		NumeroComplejo zn = z0;
		while(convergente && n < 255) {
			NumeroComplejo zn1 = zn.multiplicar(zn).sumar(z0);
			n++;
			convergente = zn1.modulo() < 4.0;
			zn = zn1;
		}
		
		return n;
	}

	public Imagen getImagen() {
		return modelo;
	}
	
	
}
