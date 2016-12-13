package stringhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class stringClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Invia dati al server
		Socket s = new Socket("LAB06_24", 9999);
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("DAI è ORA DI BASTA"); //messaggio da inviare

		// riceve del testo
		InputStreamReader isr = new InputStreamReader(s.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		System.out.println("Il client riceve:" + in.readLine());
		
		s.close();

	}

}