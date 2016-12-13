package ordinealfabetico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.Normalizer;

public class Client {
	
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket s =new Socket("localhost", 9999);
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		
		System.out.println("Inserisci primo nome: ");
		String nomeUno = getInput();
		System.out.println("Inserisci secondo nome: ");
		String nomeDue = getInput();
		System.out.println("Inserisci terzo nome: ");
		String nomeTre = getInput();
		
		out.println(nomeUno);
		out.println(nomeDue);
		out.println(nomeTre);
		
		InputStreamReader ricezione=new InputStreamReader(s.getInputStream());
		BufferedReader nomiOrdinati=new BufferedReader(ricezione);
		System.out.println("CLIENT: Ho ricevuto "+nomiOrdinati.readLine());
		
		s.close();
	}
	
	private static String getInput(){
		try {
			return BR.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
