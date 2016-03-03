package main;

import java.math.BigInteger;

public class Successor {
	BigInteger intervalStart;
	BigInteger intervalEnd;
	BigInteger node;
	int port;
	
	public Successor(BigInteger intervalStart, BigInteger intervalEnd, BigInteger node, int port) {
		this.intervalStart = intervalStart;
		this.intervalEnd = intervalEnd;
		this.node = node;
		this.port = port;
	}
}
