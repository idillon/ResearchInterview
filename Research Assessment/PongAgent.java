import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class PongAgent extends Agent {
	
	InetAddress address;
    int port = 2000;
	DatagramSocket socket = new DatagramSocket(port);
    
	public PongAgent(String name, String id) throws SocketException, UnknownHostException {
		this.name = name;
		this.agentID = id;
		this.address = InetAddress.getLocalHost();
		System.out.println(name + "[id=" + agentID + "]: Waiting for pings...");
	}
	
    public void sendMessage(String message) throws IOException {
	     byte output[] = message.getBytes();
	     // new packet with message to send, size of packet, destination, and port respectively
		 DatagramPacket packet = new DatagramPacket(output, output.length, address, 1999);
		 socket.send(packet);
		 System.out.println("Sent " + message);
	 }
 
    public String receiveMessage() throws IOException {
		byte take[] = new byte[256];
		// new packet with empty array and size of message received respectively
		DatagramPacket receive = new DatagramPacket(take, take.length);
		socket.receive(receive);
		System.out.println("Got it");
		String message = Arrays.toString(receive.getData());
		return message;
	 }
}
