// Author: Ian Dillon

import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class AgentSystem {
	static volatile Queue<String> pings = new LinkedList<String>();
	static volatile Queue<String> pongs = new LinkedList<String>();
	static volatile ArrayList<PingAgent> pingAgents = new ArrayList<PingAgent>();
	static volatile ArrayList<PongAgent> pongAgents = new ArrayList<PongAgent>();
	static volatile PingAgent newPing;
	static volatile PongAgent newPong;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Random rand = new Random();
		int i = rand.nextInt(999);
		String random = String.valueOf(i);
		// PingAgent is called
		if (args.length > 0 && args[0].equals("PingAgent")) {
			// Ping Queue is empty
			System.out.println("pings: " + pings);
			if (pings.isEmpty()) {
				// Create instance of PingAgent with name and ID
				newPing = new PingAgent("PingAgent" + random, random);
				// Keep track of object in list and queue
				pingAgents.add(newPing);
				pings.add("ping");
				newPing.sendMessage("Hello");
				// Create instance of PongAgent with name and ID
				newPong = new PongAgent("PongAgent" + random, random);
				newPong.receiveMessage();
			}
			// Ping finds a pong
			else if (pongs.peek().equals("pong")) {
				pongs.remove();
				pings.add("ping");
				newPing.sendMessage("Hello");
				newPong.receiveMessage();
			}
		}
		// PongAgent is called
		else if (args.length > 0 && args[0].equals("PongAgent")) {
			// Pong Queue is empty
			pings.add("ping");
			System.out.println("pongs: " + pongs);
			if (pongs.isEmpty()) {	
				// Create instance of PongAgent with name and ID
				newPong = new PongAgent("PongAgent" + random, random);
				pongAgents.add(newPong);
				// Keep track of object in list and queue
				pongs.add("pong");
				newPong.sendMessage("Goodbye");
				// Create instance of PongAgent with name and ID
				newPing = new PingAgent("PingAgent" + random, random);
				newPing.receiveMessage();
			}
			// Pong receives a ping
			else if (pings.peek().equals("ping")) {
				pings.remove();
				pongs.add("pong");
				newPong.sendMessage("Goodbye");
				newPing.receiveMessage();
			}
		}
	}
}
