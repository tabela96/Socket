package gastaldo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class UnIntClient {
	public static void main(String[] args) {
		// Mi connetto al server
		try {
			Socket s = new Socket("Lab06_24", 9080);
			s.getOutputStream().write((int)(Math.random()*9999));
			// legge un numero dal server
			int numero=s.getInputStream().read();
			System.out.println("Client: Ho ricevuto il numero "+numero+1);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
