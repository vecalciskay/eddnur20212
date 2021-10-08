package animacion.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import animacion.model.Cuadrado;

public class FrameAnim extends JFrame {

	protected Cuadrado modelo;
	protected boolean pleaseStop;
	protected Thread animador;
	
	public FrameAnim() {
		init();
		pleaseStop = false;
	}
	
	public void init() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		modelo = new Cuadrado(30);
		PanelAnim panel = new PanelAnim(modelo);
		modelo.addObserver(panel);
		
		this.getContentPane().add(panel);
		
		JButton btn = new JButton("Comenzar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pleaseStop = false;
				btn_comenzar();
			}
		});
		this.getContentPane().add(btn, BorderLayout.NORTH);
		
		btn = new JButton("Parar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pleaseStop = true;
			}
		});
		this.getContentPane().add(btn, BorderLayout.SOUTH);
		this.pack();
	}
	
	protected void btn_comenzar() {
		
		if (animador == null || !animador.isAlive()) {
		
			animador = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(!pleaseStop) {
						modelo.ejecutarUnPasoAnimacion();
						try {
							Thread.sleep(50);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			});
			
			animador.start();
		}
	}

	public static void main(String[] args) {
		FrameAnim win = new FrameAnim();
		win.setVisible(true);
	}
}
