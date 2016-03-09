package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Constants {
	
	public PrintStream logStream = null;
	public PrintStream originalStream = System.out;
	Constants(){
		try {
			logStream = new PrintStream(new FileOutputStream("log.txt", true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
