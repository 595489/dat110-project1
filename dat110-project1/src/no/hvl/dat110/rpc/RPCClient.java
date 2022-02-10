package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		// TODO - START
		// connect using the underlying messaging layer connection
		if(connection == null) {

			try {
				connection = msgclient.connect(); 
			}catch (Exception e){
				System.out.println("Error occured" + e); 
			}
		}
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
	}
	
	public void disconnect() {
		
		// TODO - START
		// disconnect/close the underlying messaging connection
		
		if(connection != null) {
			try {
				connection.close(); 
				connection = null; 
			}catch(Exception e) {
				System.out.println("Error occurred" + e);
			}
		}
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
//		
		// TODO - END
		
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval = null;
		
		// TODO - START 
		
		/* 
		 * 
		Make a remote call on the RPC server by sending an RPC request message
		and receive an RPC reply message
		
		params is the marshalled parameters from the client-stub
				
		The rpcid, params, and return value must be encapsulated/decapsulated
		according to the RPC message format
			
		*/

		Message request = new Message(RPCUtils.encapsulate(rpcid, params));
		connection.send(request);
		Message recieve = connection.receive();
		returnval = RPCUtils.decapsulate(recieve.getData());


//		Message request = new Message(params);
//		MessageUtils.encapsulate(request);
//		connection.send(request);
//		Message recieve = connection.receive();
//		returnval = recieve.getData();
				
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		return returnval;
		
	}

}
