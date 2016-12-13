package calcolatrice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientNumeri {
	public static void main(String[] args){
		try{
			Socket s=new Socket("Lab06_24", 9080);
			InputStreamReader input=new InputStreamReader(System.in);
			BufferedReader numero1=new BufferedReader(input);
			int n1;
			int n2;
			int operazione;
			System.out.println("CLIENT: Inserisci n1: ");
			n1=Integer.parseInt(numero1.readLine());
			s.getOutputStream().write(n1);
			BufferedReader numero2=new BufferedReader(input);
			System.out.println("CLIENT: Inserisci n2: ");
			n2=Integer.parseInt(numero2.readLine());
			s.getOutputStream().write(n2);
			BufferedReader oper=new BufferedReader(input);
			System.out.println("CLIENT: Scegli:");
			System.out.println("0: Addizione");
			System.out.println("1: Sottrazione");
			operazione=Integer.parseInt(oper.readLine());
			s.getOutputStream().write(operazione);
			int risultato=s.getInputStream().read();
			System.out.println("CLIENT: Ho ricevuto il risultato "+risultato);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
