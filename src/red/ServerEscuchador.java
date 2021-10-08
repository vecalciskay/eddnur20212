package red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementa el protocolo EDDP para replicar la conversacion.
 * Lo unico que hace es responder la misma frase que se le envie.
 * Esto hasta que nos envien la palabra FIN
 * 
 * El puerto que utiliza es el 9394
 * 
 * @author Vladimir
 *
 */
public class ServerEscuchador {

	public static final int PUERTO = 9394;
	
	public ServerEscuchador() {
		
	}
	
	public static void main(String[] args) throws IOException {
		ServerEscuchador srvEscuchador = new ServerEscuchador();
		srvEscuchador.escuchar();
	}
	
	public void escuchar() throws IOException {
		
		ServerSocket srv = new ServerSocket(PUERTO);
		
		System.out.println("Escuchando en puerto " + PUERTO + ", espera conexion...");
		Socket cltSocket = srv.accept();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(cltSocket.getInputStream()));
		PrintWriter printer = new PrintWriter(cltSocket.getOutputStream());
		
		String linea = reader.readLine();
		System.out.println("<<< " + linea);
		
		while(linea != null && !linea.equals("FIN")) {
			System.out.println(">>> " + linea);
			printer.println(linea);
			printer.flush();
			
			linea = reader.readLine();
			System.out.println("<<< " + linea);
		}
		
		System.out.println("FIN ok, cierra todo");
		
		cltSocket.close();
		srv.close();
	}
}
