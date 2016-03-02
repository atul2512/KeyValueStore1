package main;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import java.net.*;
import java.util.Date;

public class PeerNode {
	ArrayList<Integer> peerPorts=new ArrayList<Integer>();
	String filePath="";
	int port;
	Map<BigInteger,Successor> fingerTable;
	

	public PeerNode(int port2, String filePath2) {
		// TODO Auto-generated constructor stub
		this.port=port2;
		this.filePath=filePath2;
		fingerTable=new LinkedHashMap<BigInteger,Successor>();
		
		new Thread(new Runnable(){
			public void run(){
				try {
					ServerThread();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}



	public void ServerThread() throws IOException{
		ServerSocket s = new ServerSocket(port);
    	System.out.println("Server socket created at port "+port+" and waiting....");
        while(true)
        {  	
        	Socket conn = s.accept();
        	System.out.println("Connection received from: " + conn.getInetAddress().getHostName() + " : " + conn.getPort());
        	new ClientHandler(conn,port,fingerTable).start();  
        }
	}
	
	public void asClient(String serverName,int port) throws UnknownHostException, IOException{
		Socket client=new Socket(serverName,port);
		System.out.println("Just connected to " 
				 + client.getRemoteSocketAddress());
		OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF("Hello from "
                + client.getLocalSocketAddress());
        InputStream inFromServer = client.getInputStream();
        DataInputStream in =
                new DataInputStream(inFromServer);
        System.out.println("Server says " + in.readUTF());
        client.close();
	}
	
	
	public void join(PeerNode coord){
		
	}
	
	
	
}
