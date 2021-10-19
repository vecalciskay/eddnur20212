package regex;

import java.util.regex.*;

public class Ejemplos {
	public static void main(String[] args) {
		
		noHacerEsto();

		conExpresionRegular();
	}

	private static void conExpresionRegular() {
		String linea = "DISPARO 234,65";
		
		String expreg = "^DISPARO\\s+([0-9]{1,3})\\s*,\\s*([0-9]{1,3})$";
		
		Pattern p = java.util.regex.Pattern.compile(expreg);
		Matcher m = p.matcher(linea);
		
		int x = 0;
		int y = 0;
		
		if (m.matches()) {
			x = Integer.parseInt( m.group(1));
			y = Integer.parseInt(m.group(2));
		}
		
		System.out.println("x:" + x + " , y:" + y);
	}

	private static void noHacerEsto() {
		// DISPARO 234,65
		String linea = "DISPARO 234,65";
		int x = 0; int y = 0;
		
		String[] cmdCoord = linea.split(" ");
		String[] xyStrings = cmdCoord[1].split(",");
		x = Integer.parseInt(xyStrings[0]);
		y = Integer.parseInt(xyStrings[1]);
		
		System.out.println("x:" + x + " , y:" + y);
		
		// Que pasa si la primera palabra NO ES 'DISPARO'?
		// Qué pasa si NO hay espacio?
		// Que pasa si el cmd es 'DISPARO  234,65'
		// Que pasa si el cmd es 'DISPARO  234 ,   65 '
		// Donde se testea que x y y sean enteros?
	}
}
