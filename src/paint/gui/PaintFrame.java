package paint.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import paint.modelo.Imagen;
import paint.transformacion.FlipHorizontal;
import paint.transformacion.TonosDeGris;
import paint.transformacion.Transformacion;
import paint.transformacion.TransformacionSoloRojo;


public class PaintFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Imagen modelo;
	
	public PaintFrame() {
		inicializar();
		this.setVisible(true);
	}
	
	public void inicializar() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar jmb = new JMenuBar();
		
		// --------------MENU ARCHIVO
		JMenu archivo = new JMenu("Archivo");
		
		JMenuItem menuItem = new JMenuItem("Cargar 1");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivo_Cargar("e:\\temp\\foto1.jpg");
			}
		});
		archivo.add(menuItem);
		
		menuItem = new JMenuItem("Cargar 2");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivo_Cargar("e:\\temp\\foto2.jpg");
			}
		});
		archivo.add(menuItem);
		
		menuItem = new JMenuItem("Cargar 3");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivo_Cargar("e:\\temp\\foto3.jpg");
			}
		});
		archivo.add(menuItem);
		
		archivo.addSeparator();
		
		jmb.add(archivo);
		
		//-----------------MENU TRANSFORMACIONES
		
		archivo = new JMenu("Transformaciones");
		
		menuItem = new JMenuItem("Solo Rojo");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaTransformacion("TransformacionSoloRojo");
			}
		});
		archivo.add(menuItem);
		
		menuItem = new JMenuItem("Tonos de gris");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaTransformacion("TonosDeGris");
				//archivo_TonosDeGris();
			}
		});
		archivo.add(menuItem);
		
		menuItem = new JMenuItem("Flip Horizontal");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaTransformacion("FlipHorizontal");
			}
		});
		archivo.add(menuItem);
		
		jmb.add(archivo);
		
		this.setJMenuBar(jmb);	
		
		this.getContentPane().setLayout(new BorderLayout());
		modelo = new Imagen(600,400);
		PaintPanel pnl = new PaintPanel();
		modelo.addObserver(pnl);
		this.getContentPane().add(pnl, BorderLayout.CENTER);
		
		this.pack();
	}
	
	protected void nuevaTransformacion(String claseTransformacion) {
		Transformacion t = null;
		try {
			t = (Transformacion) (Class.forName("paint.transformacion." + claseTransformacion).getDeclaredConstructor().newInstance());
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (t != null)
			t.transformar(modelo);
	}
//
//	protected void archivo_FlipHorizontal() {
//		FlipHorizontal t = new FlipHorizontal();
//		t.transformar(modelo);
//	}
//
//	protected void archivo_TonosDeGris() {
//		TonosDeGris t = new TonosDeGris();
//		t.transformar(modelo);
//	}
//
//	protected void archivo_SoloRojo() {
//		TransformacionSoloRojo t = new TransformacionSoloRojo();
//		t.transformar(modelo);
//	}

	protected void archivo_Cargar(String ruta) {
		BufferedImage bi = null;
		try {
			File f = new File(ruta);
			bi = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelo.setImagen(bi);
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
