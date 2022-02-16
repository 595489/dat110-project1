package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCLocalStub;
import no.hvl.dat110.rpc.RPCUtils;

public class SensorStub extends RPCLocalStub {

	private byte RPCIDREAD = 1;
	
	public SensorStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public int read() {
		
		int temp = 0;
		
		// TODO - START
		// implement marshalling, call and unmarshalling for read RPC method
		rpcclient.connect();
		byte[] send = RPCUtils.marshallInteger(temp);
		byte[] recieve = rpcclient.call(RPCIDREAD, send);
		temp = RPCUtils.unmarshallInteger(recieve);
		
		// TODO - END
		
		return temp;
	}
	
}
