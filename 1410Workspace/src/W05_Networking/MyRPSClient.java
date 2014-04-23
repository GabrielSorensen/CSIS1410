import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class MyRPSClient{

	private static boolean connected;
	private static int attempt;
	private static Socket client;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	private static String r = "Rock";
	private static String p = "Paper";
	private static String s = "Scissors";

	public static void main(String[] args){
		//connect to the server
		connect("127.0.0.1", 12345);
		System.out.println("Begining Game of Sock, Paper, Scissors with server; sending Rock to start.");
		while (connected) {
			for (int i=0; i<50; i++) {
				try {
					//My turn first, send rock.
					sendMSG(r);
					String result = new String(in.readObject().toString());
					//get response from server
					System.out.println("Result: "+result);
					//Server goes first, get server's choice
					String op = new String(in.readObject().toString());
					String counter = new String(beatThis(op));
					System.out.println("Opponent chose: "+op+" \t Countering w/ "+counter);
					//send the move that beats his move.
					sendMSG(counter);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			connected = false;
		}
		closeConnections();
	}
	public static String randRPS() {
		//chooses a random move, This isn't nessesary for the homework.
		int c = (int)(Math.random()*3+1);
		if (c==1) {
			return r;
		} else if (c==2) {
			return p;
		} else if (c==3) {
			return s;
		} else {
			return "Rock";
		}
	}
	public static String beatThis(String op) {
		//This method, takes a string and gives back the move that beats it
		if (op.equals("Rock")) {
			return "Paper";
		} else if (op.equals("Paper")) {
			return "Scissors";
		} else if (op.equals("Scissors")) {
			return "Rock";
		} else {
			return "Paper";
		}
	}
	public static void sendMSG(String message) {
		//This method writes and sends a string to the server
		try {
			out.writeObject(message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getMSG() {
		//This gets messages from the server
		try {
			String s = new String(in.readObject().toString());
			return s;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Did not get any MSG, Could have been an error.";

	}
	public static boolean connect(String hostIP, int port){
		//This connects to the server, and if there are problems it retrys 3 times
		connected = false;
		System.out.print("Attempting to connect");
		try {
			client = new Socket(InetAddress.getByName(hostIP), port);
			System.out.print(".");
			out = new ObjectOutputStream(client.getOutputStream());
			System.out.print("..");
			in = new ObjectInputStream(client.getInputStream());
			System.out.print("....");
			System.out.println("Connected, begin transmissions.");
			connected = true;
			return connected;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something happened that was not expected. Will attempt a couple of times(3).");
			attempt+=1;
			if (attempt<=3) {
				connect(hostIP, port);
			} else {
				System.out.println("Attempts failed, exiting");
				System.exit(0);
			}
			return false;
		}
	}
	public static void closeConnections() {
		//Once the 100 games are finished, dont forget to close the Socket connection to the server.
		try {
			client.close();
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
