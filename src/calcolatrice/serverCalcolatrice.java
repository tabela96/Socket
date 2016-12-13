package calcolatrice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverCalcolatrice {
	public static void main(String[] args){
		ServerSocket ss;
		try{
			ss=new ServerSocket(9080);
			while(true){
				Socket clientSocket=ss.accept();
				int n1=clientSocket.getInputStream().read();
				int n2=clientSocket.getInputStream().read();
				int operazione=clientSocket.getInputStream().read();
				int risultato=0;
				if(operazione==0){
					risultato=n1+n2;
					System.out.println("SERVER: somma="+risultato);
				}
				if(operazione==1){
					risultato=n1-n2;
					System.out.println("SERVER: differenza="+risultato);
				}
				clientSocket.getOutputStream().write(risultato);
			}
		}catch(IOException e1){
				e1.printStackTrace();
		}
	}
}
