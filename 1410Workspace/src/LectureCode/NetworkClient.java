import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 
 * @author
 *
 */
public class NetworkClient {

	public NetworkClient(){
		//Step 1
		//Create a Socket called client on your machine using InetAddress.getByName("127.0.0.1") and port 12345
		//Step 2
		//Get the ObjectOutputStream - new ObjectOutputStream (client.getOutputStream())
		//Get the ObjectInputStream - new ObjectInputStream(client.getInputStream())
		//Step 3
		//use the writeObject method to send a string to the server
		//flush the output to actually send the message and not just store it in the buffer
		//print what the server sent back using the readObject method - it throws an exception
		//Step 4
		//The client automatically closes when the program exits
		try {
			Socket client = new Socket(InetAddress.getByName("172.0.0.1"), 12345);
			
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			
			out.writeObject("Hello, this is client");
			out.flush();
			String s = new String(in.readObject().toString());
			System.out.println("Server Said: "+s);


			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}



	}

	public static void main(String[] args) {
		new NetworkClient();
	}

}
