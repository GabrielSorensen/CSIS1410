import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.corba.se.spi.activation.Server;

/**
 * 
 * @author SUU
 *
 */
@SuppressWarnings("unused")
public class NetworkServer {
	private boolean running = true;

	public NetworkServer(){
		//Step 1
		//Create a ServerSocket on port 12345 with length 100
		//Step 2
		//Create a Socket called socket for the ServerSocket.accept() method
		//print the InetAddress - socket.getInetAddress()
		//print the HostName = socket.getInetAddress().getHostName();
		//Step 3
		//Get the ObjectInputStream from the socket - new ObjectInputStream(socket.getInputStream() );
		//Get the ObjectOutputStream from the socket - new ObjectOutputStream(socket.getOutputStream())
		//Step 4
		//Print the message from the ObjectInputStream using the readObject() method - throws and exception
		//Send a message back to the client using the writeObject method
		//flush the output so that the buffer actually sends
		//Step 5
		//The server automatically closes when the program exits
		try {
			ServerSocket server = new ServerSocket(12345, 100);
			while(running) {
				Socket socket = server.accept();
				System.out.println("Address is: "+socket.getInetAddress());
				System.out.println("Hostname is: "+socket.getInetAddress().getHostAddress());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				String s = new String(in.readObject().toString());
				System.out.println(s);
				out.writeObject("Sup homie?");
				out.flush();
			}
			server.close();

		} catch (IOException e) {


			System.err.println("Help, I'm broke.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}


	public static void main(String[] args) {
		new NetworkServer();

	}

}
