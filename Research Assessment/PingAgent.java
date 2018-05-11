import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class PingAgent extends Agent {
	
    InetAddress address;
    int port = 1999;
    DatagramSocket socket = new DatagramSocket();
	
	public PingAgent (String name, String id) throws SocketException, IOException {
		this.name = name;
		this.agentID = id;
		this.address = InetAddress.getLocalHost();
		System.out.println(name + "[id=" + agentID + "]: Looking for PongAgents...");
	}
	
	public void sendMessage(String message) throws IOException {
	     byte output[] = message.getBytes();
	     // new packet with message to send, size of packet, destination, and port respectively
		 DatagramPacket packet = new DatagramPacket(output, output.length, address, 2000);
		 socket.send(packet);
		 System.out.println("Sent " + message);
	 }
	 
	public String receiveMessage() throws IOException {
		byte take[] = new byte[256];
		// new packet with buffer to receive and size of message received respectively
		DatagramPacket receive = new DatagramPacket(take, take.length);
		socket.receive(receive);
		System.out.println("Got it");
		String message = Arrays.toString(receive.getData());
		System.out.println(message);
		return message;
	 }
}
