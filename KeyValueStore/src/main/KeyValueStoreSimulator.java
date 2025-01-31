package main;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintStream.*;
import java.util.*;

public class KeyValueStoreSimulator {
	public static ArrayList<PeerNode> peers = new ArrayList<PeerNode>();
	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static int firstNodePort;
	public static int index=0;
	
	KeyValueStoreSimulator(){
		for(int i=5000;i<6500;i++)
			arr.add(i);
		Collections.shuffle(arr);
		firstNodePort = arr.get(0);
	}
	public static int getRandomPort(){
		
		return arr.get(index++);
		
	}
	
	public static void join(int port){
		OurRMI ourRMI = null;
		peers.add(new PeerNode(port,"C:/Users/srinivasMaram/workspace/KeyValueStore/keys/5678.txt"));
		if(index==1){
			ourRMI = new OurRMI(port, "join"+":5623"+":"+":");
			ourRMI.result();
		}
		else{
			ourRMI = new OurRMI(port, "join:"+firstNodePort+":"+":");
			ourRMI.result();
		}
	}
	
	public static void insertKey(String key, String value){
		OurRMI ourRMI = null;
		ourRMI = new OurRMI(firstNodePort, "findKeySuccessor: "+ key+" "+value+" "+"insert");
		System.out.println(ourRMI.result());
	}
	
	public static String play(String key){
		OurRMI ourRMI = new OurRMI(firstNodePort, "findKeySuccessor: "+ key+" deadbeef"+" "+"retrieve");
		return ourRMI.result();
	}
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for(int i=5000;i<6500;i++)
//			arr.add(i);
//		Collections.shuffle(arr);
//		firstNodePort = arr.get(0);
		
//		int choice;
//
//		Scanner sc = new Scanner(System.in);
//		
//		do{
//			System.out.println("**MENU**");
//			System.out.println("1. Join node");
//			System.out.println("2. Insert Key");
//			System.out.println("3. Retrieve Key");
//			System.out.println("4. Quit");
//			System.out.println("Enter choice:");
//			choice = sc.nextInt();
//			sc.nextLine();
//			
//			switch(choice){
//				case 1:
//					int nodeAddr = getRandomPort();
//					peers.add(new PeerNode(nodeAddr,"C:/Users/srinivasMaram/workspace/KeyValueStore/keys/5678.txt"));
//					join(nodeAddr);
//					break;
//				case 2:
//					System.out.println("Enter Song Name:");
//					String key=sc.nextLine();
//					System.out.println("Enter Song Link:");
//					String value=sc.nextLine();
//					//System.setOut(dummyStream);
//					insertKey(key, value);
//					//System.setOut(originalStream);
//					break;
//				case 3:
//					System.out.println("Enter Song Name to retrieve:");
//					String fetchKey=sc.nextLine();
//					String link = play(fetchKey);
//					System.out.println(link);
//					break;
//				default:
//					break;
//					
//					
//			}
//		
//		}while(choice!=4);
		
//		for(int j=0;j<5;j++){
//			System.out.println(getRandomPort());
//		}
//	}

}
