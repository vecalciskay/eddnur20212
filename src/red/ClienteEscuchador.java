package red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteEscuchador {

	public ClienteEscuchador() {
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ClienteEscuchador clienteEscuchador = new ClienteEscuchador();
		clienteEscuchador.conectar();
	}
	
	public void conectar() throws UnknownHostException, IOException {
		
		Socket clt = new Socket(InetAddress.getLocalHost(), ServerEscuchador.PUERTO);
		System.out.println("Cliente conectado a localhost en puerto " + ServerEscuchador.PUERTO);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(clt.getInputStream()));
		PrintWriter printer = new PrintWriter(clt.getOutputStream());
		
		printer.println("Buenos dias");
		printer.flush();
		
		String linea = reader.readLine();
		System.out.println("SRV: " + linea);
		
		printer.println("Algo mas que querramos decir");
		printer.flush();
		
		linea = reader.readLine();
		System.out.println("SRV: " + linea);
		
		printer.println("FIN");
		printer.flush();
		
		clt.close();
	}
}
