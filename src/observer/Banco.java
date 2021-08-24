package observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Banco {
	
	private static Logger logger = LogManager.getRootLogger();

	public static void main(String[] args) {
		/*
		logger.debug("Este mensaje 1");
		logger.info("Este mensaje 1");
		logger.warn("Este mensaje 1");
		logger.error("Este mensaje 1");
		*/
		
		CuentaBanco c1 = new CuentaBanco("Hugo");
		CuentaBanco c2 = new CuentaBanco("Paco");
		
		PromoComercial2x100H500 promoComercial2x100H500 = new PromoComercial2x100H500();
		c1.addPromo(promoComercial2x100H500);
		c2.addPromo(promoComercial2x100H500);
		
		c1.depositar(300);
		c2.depositar(600);
		
		// c1 saldo = 306
		// c2 saldo = 610
		System.out.println(c1);
		System.out.println(c2);
	}
}
