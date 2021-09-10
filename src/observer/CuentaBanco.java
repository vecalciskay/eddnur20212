package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CuentaBanco {

	private static Logger logger = LogManager.getRootLogger();
	private String titular;
	private double saldo;
	private PropertyChangeSupport cambios;
	
	public CuentaBanco(String t) {
		saldo = 0;
		titular = t;
		cambios = new PropertyChangeSupport(this);
	}
	
	public void depositar(double monto) {
		double saldoAnterior = saldo;
		saldo += monto;
		logger.info("Se depositaron " + monto + ", el saldo nuevo: " + saldo);
		// ssaldo anterior= 100, saldo actual=400  (monto depositado=300)
		cambios.firePropertyChange(OperacionCuenta.Deposito.toString(), saldoAnterior, saldo);
	}
	
	public double retirar(double monto) {
		double montoEfectivoARetirar = monto;
		if (saldo - montoEfectivoARetirar < 0) {
			montoEfectivoARetirar = saldo; 
		}
		saldo -= montoEfectivoARetirar;
		logger.info("Se retiro " + montoEfectivoARetirar + ", el saldo nuevo: " + saldo);
		return montoEfectivoARetirar;
	}
	
	public double getSaldo()  {
		return saldo;
	}
	
	public String getTitular() {
		return titular;
	}

	public void depositarInterno(double monto) {
		saldo += monto;
		cambios.firePropertyChange("VISOR", true, false);
	}
	
	@Override
	public String toString() {
		return "Titular: " + titular + " - Saldo: " + saldo;
	}

	public void addPromo(PropertyChangeListener promo) {
		cambios.addPropertyChangeListener(promo);
	}

	public void addVisor(PropertyChangeListener visor) {
		cambios.addPropertyChangeListener(visor);
	}
}
