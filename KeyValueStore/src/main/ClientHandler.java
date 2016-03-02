package main;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import java.net.*;

public class ClientHandler extends Thread{
	Socket server;
	int port;
	Map<BigInteger,Successor> fingerTable;
	ClientHandler(Socket conn,int port,Map<BigInteger,Successor> fingerTable){
		this.server=conn;
		this.port=port;
		this.fingerTable=fingerTable;
	}
	
	public void run(){
		System.out.println("Just connected to "
                + server.getRemoteSocketAddress());
         DataInputStream in = null;
		try {
			in = new DataInputStream(server.getInputStream());
			
			String recevied = in.readUTF();
			System.out.println("recevied msg: "+recevied);
			
			
			DataOutputStream out = null;
			
			out = new DataOutputStream(server.getOutputStream());
			
			
			out.writeUTF("Thank you for connecting to "
				    + server.getLocalSocketAddress() + "\nGoodbye!");
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
