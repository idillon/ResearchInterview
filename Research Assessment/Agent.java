
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public abstract class Agent {
	
	public String name;
	public String agentID;
	//public ArrayList<NetworkInterface> interfaces;
	
	public Agent() throws SocketException {
		// list of all network interfaces in the system
		//this.interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
	}
	
	public String getName() {
        return name;
    }
	
	public String getAgentID() {
        return agentID;
    }
	
}
