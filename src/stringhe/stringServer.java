package stringhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class stringServer {

	public static void main(String[] args) throws IOException {
		// Crei un server di connessione
		ServerSocket ss = new ServerSocket(9999);
		while (true) {
			// riceve una connessione
			Socket s = ss.accept();
			// riceva del testo
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			System.out.println("Il server riceve:" + in.readLine());
			// invia del testo
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			out.println(" Ciaone dal serverone!");
			s.close();
			// riparte
		}

	}

}