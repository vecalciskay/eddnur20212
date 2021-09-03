package observer.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import observer.CuentaBanco;
import observer.PromoComercial2x100H500;

public class BancoWindow extends JFrame implements PropertyChangeListener {

	private JLabel saldo;
	private CuentaBanco modelo;
	
	public BancoWindow() {
		init();
	}
	
	public void init() {
		modelo = new CuentaBanco("Hugo");
		PromoComercial2x100H500 promoComercial2x100H500 = new PromoComercial2x100H500();
		modelo.addVisor(this);
		modelo.addPromo(promoComercial2x100H500);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		saldo = new JLabel("Saldo");
		this.getContentPane().add(saldo, BorderLayout.NORTH);
		refrescarSaldo();
		
		JButton depositarBtn = new JButton("Depositar 120");
		depositarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				depositar120();
			}
		});
		
		this.getContentPane().add(depositarBtn, BorderLayout.SOUTH);
		
		this.pack();
	}

	private void refrescarSaldo() {
		saldo.setText("Saldo: " + modelo.getSaldo());
	}

	protected void depositar120() {
		modelo.depositar(120);
	}
	
	public static void main(String[] args) {
		BancoWindow window = new BancoWindow();
		window.setVisible(true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		refrescarSaldo();
	}
}
