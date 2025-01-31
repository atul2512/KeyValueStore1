package serverPort;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.math.BigInteger;

import main.PeerVar;

public class ClientHandNP  extends Thread {
	Socket server;
	int port;
	HashMap<BigInteger,Integer> nametoPort=null;
	ClientHandNP(Socket conn,int port,HashMap<BigInteger,Integer> nametoPort){
		this.server=conn;
		this.port=port;
		this.nametoPort=nametoPort;
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
