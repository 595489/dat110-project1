package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		
		// TODO - START

		// Potential implementation. Most likely needs refactoring to be properly/better constructed
		try {
			if (data.length < 128) {
				this.data = data;
			}
		}
		catch (NullPointerException e){
			throw new NullPointerException("nullpointer exception");
		}

		// TODO - END
	}

	public byte[] getData() {
		return this.data; 
	}

}
