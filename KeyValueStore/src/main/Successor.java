package main;

import java.math.BigInteger;

public class Successor {
	BigInteger intervalStart;
	BigInteger intervalEnd;
	BigInteger node;
	int port;
	
	public Successor(BigInteger is, BigInteger ie, BigInteger n, int p) {
		intervalStart = is;
		intervalEnd = ie;
		node = n;
		port = p;
	}
}
