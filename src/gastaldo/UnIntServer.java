package gastaldo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnIntServer {
	public static void main(String[] args) {
		// Avvio il server
		ServerSocket ss;
		try {
			ss = new ServerSocket(9080);
			while (true) {				
				Socket clientSocket = ss.accept(); // Accetta la connessione
				int numero=clientSocket.getInputStream().read();
				System.out.println("Server: Ho ricevuto il numero "+numero);
				// invio il numero aumentato di 1
				clientSocket.getOutputStream().write(numero+1);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}