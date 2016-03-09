package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.*;

public class PeerVar {

	Constants global = new Constants();
	String filePath="";
	int port;
	List<Successor> fingerTable;
	BigInteger nodeName;
//	PeerNode Successor,Predecessor;
	BigInteger succ,pred;
	int succPort,predPort;
	boolean serverUp=false;
	
	
	HashMap<BigInteger,String> keyValue;
	HashMap<BigInteger, String> keysAsReplica1;
	HashMap<BigInteger, String> keysAsReplica2;
	
	List<String> myReplicas;
	
	PeerVar(int port,String filePath){
		

		this.port=port;
		this.filePath=filePath;
		fingerTable=new ArrayList<Successor>();
		nodeName=ShaGen.shaGenerator("127.0.0.1:"+port);
		System.setOut(global.logStream);
		System.out.println("Hash for port "+port+" "+nodeName);
		System.setOut(global.originalStream);
		
		
		for(int i=0;i<Vars.m;i++){
			Successor temp=new Successor(new BigInteger("2").pow(i).add(this.nodeName).mod(new BigInteger("2").pow(Vars.m)),
					new BigInteger("2").pow(i+1).add(this.nodeName).mod(new BigInteger("2").pow(Vars.m)),this.nodeName,this.port);
			fingerTable.add(temp);
		}
		
		keyValue= new HashMap<BigInteger,String>();
		keysAsReplica1 = new HashMap<BigInteger,String>();
		keysAsReplica2 = new HashMap<BigInteger,String>();
		
		myReplicas = new ArrayList<String>();
		
		myReplicas.add(nodeName +" "+port);
		myReplicas.add(nodeName +" "+port);
		serverUp=true;
	}
	
}
