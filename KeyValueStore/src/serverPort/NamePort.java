package serverPort;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.math.BigInteger;
import java.util.HashMap;

import main.ClientHandler;

public class NamePort {
	
	int port;
	NamePort(int port){
		this.port=port;
	}
	HashMap<BigInteger,Integer> nametoPort=new HashMap<BigInteger,Integer>(); 
	
	
	public void ServerThread() throws IOException{
		ServerSocket s = new ServerSocket(port);
    	System.out.println("Server socket created at port "+port+" and waiting....");
        while(true)
        {  	
        	Socket conn = s.accept();
        //	System.out.println("Connection received from: " + conn.getInetAddress().getHostName() + " : " + conn.getPort());
        	new ClientHandNP(conn,port,nametoPort).start();
        }
	}
}
