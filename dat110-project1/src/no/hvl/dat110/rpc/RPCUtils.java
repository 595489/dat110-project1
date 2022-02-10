package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = null;
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		rpcmsg = new byte[128];
		rpcmsg[0] = rpcid;
		for (int i = 0; i < rpcmsg.length; i++){
			rpcmsg[i+1] = payload[i];
		}

		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = null;
		
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the  RPC message syntax
		payload = new byte[rpcmsg.length - 1];
		for (int i = 0; i < payload.length; i++){
			payload[i] = rpcmsg[i + 1];
		}

		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return payload;
		
	}
	
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START 

		encoded = str.getBytes();

//		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return encoded;
	}
	
	public static String unmarshallString(byte[] data) {
		
		String decoded = null; 
		
		// TODO - START 

		decoded = new String(Arrays.copyOf(data, data.length));
//		decoded = "";
//		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
//		for (int i = 0; i < data.length; i++){
//			decoded += byteBuffer.getChar(i);
//		}

//		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 

//		encoded = new byte[1];
//		encoded[0] = 1;

//		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
				
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		return;
//		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}
	
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}
	
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
		
		// TODO - START 

		encoded = new byte[4];
		ByteBuffer byteBuffer = ByteBuffer.wrap(encoded);
		byteBuffer.putInt(x);

//		//Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return encoded;
	}
	
	
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		// TODO - START 
		ByteBuffer byteBuffer = ByteBuffer.wrap(data);
		decoded = byteBuffer.getInt();

//		// Standard stuff. Remove after implementing method
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return decoded;
		
	}
}
