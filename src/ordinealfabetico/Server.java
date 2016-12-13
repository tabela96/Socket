package ordinealfabetico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException{
		ServerSocket ss=new ServerSocket(9999);
		while(true){
			String[] nomi=new String[3];
			Socket s=ss.accept();
			//System.out.println("E' arrivato");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			nomi[0]=in.readLine();
			nomi[1]=in.readLine();
			nomi[2]=in.readLine();
			System.out.println("Ho letto i 3 nomi");
			
			Arrays.sort(nomi);
			
			PrintWriter out=new PrintWriter(s.getOutputStream(), true);
			
			System.out.println("SERVER: Invio stringhe ordinate = "+nomi[0]+" "+nomi[1]+" "+nomi[2]);
			
			out.println("dal SERVER i seguenti nomi (ordinati) = "+nomi[0]+" "+nomi[1]+" "+nomi[2]);
			s.close();
		}
	}
}
