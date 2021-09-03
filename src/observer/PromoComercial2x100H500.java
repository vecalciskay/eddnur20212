package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PromoComercial2x100H500 implements PropertyChangeListener {

	private static Logger logger = LogManager.getRootLogger();

	public PromoComercial2x100H500() {
		logger.debug("Crea la promo");
	}

	public void ejecutarPromo(CuentaBanco c, OperacionCuenta op, double monto) {
		if (op == OperacionCuenta.Retiro) {
			logger.debug("No es un deposito");
			return;
		}
		if (op == OperacionCuenta.Deposito) {

			if (monto < 100) {
				logger.debug("El deposito es menor a 100");
				return;
			}

			// 145 -> 2
			// 383 -> 6
			// 1125 -> 10
			// 800 -> 10

			// 1, 5, 15, 234
			/*
			 * double montoPromo = 2; if (monto >= 200) montoPromo = 4; if (monto >= 300)
			 * montoPromo = 6; if (monto >= 400) montoPromo = 8; if (monto >= 500)
			 * montoPromo = 10;
			 */

			double montoC = (monto >= 500 ? 500 : monto);
			double montoPromo = 2 * (int) (montoC / 100);

			logger.debug("El deposito fue de " + monto + " y la promo calculada es de: " + montoPromo);

			c.depositarInterno(montoPromo);
			return;
		}

		logger.debug("Han habido cambios, pero ninguno para la promo");
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (!evt.getPropertyName().equals(OperacionCuenta.Deposito.toString()))
			return;

		CuentaBanco cuentaBanco = (CuentaBanco) evt.getSource();
		OperacionCuenta operacionCuenta = OperacionCuenta.Deposito;
		double monto = (double) (evt.getNewValue()) - (double) (evt.getOldValue());

		ejecutarPromo(cuentaBanco, operacionCuenta, monto);
	}
}
