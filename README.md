# ResearchInterview
Since the files are raw Java files and do not import any special libraries, the only important thing to have is a JDK installed. 
If using ubuntu, you can simply get a JDK by running sudo apt install gcj-4.9-jdk

From here, you can download the zip file for the repository and then decompress it, or you can clone the repository into a desginated file

To run:
1. Open two VMs
2. Obtain files from repository
3. Open terminals/command prompts in both
4. Navigate to folder in which files were placed
5. Run the command javac AgentSystem.java in both terminals
6. Once they are compiled, run java AgentSystem PingAgent on one VM, and java AgentSystem PongAgent on the other

Notes: 
It doesn't work, but the effort to connect two programs via UDP is there.
I understand how Datagram sockets and packets work, but was unable to connect two virtual machines via localHost.
