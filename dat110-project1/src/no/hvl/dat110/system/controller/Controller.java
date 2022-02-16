package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCClientStopStub;

import static java.lang.Thread.sleep;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) {
		
		DisplayStub display;
		SensorStub sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		// create RPC clients for the system
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// setup stop methods in the RPC middleware
		RPCClientStopStub stopdisplay = new RPCClientStopStub(displayclient);
		RPCClientStopStub stopsensor = new RPCClientStopStub(sensorclient);
				
		// TODO - START
		
		// create local display and sensor stub objects
		// connect to sensor and display RPC servers
		display = new DisplayStub(displayclient);
		sensor = new SensorStub(sensorclient);
		
		displayclient.connect();
		sensorclient.connect();
		//??

		int x = sensor.read();
		System.out.println("Controller recieved temp: " + x);
		display.write(Integer.toString(x));

//		// Doesn't work yet
//		int x;
//		for (int i = 0; i < 20; i++){
//			x = sensor.read();
//			display.write(Integer.toString(x));
//			try{
//				sleep(1000);
//			}
//			catch (InterruptedException e){
//				System.out.println("Error... " + e);
//			}
//		}
		
		// TODO - END
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
