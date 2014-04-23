import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ReadShakespear {

	private static File tempest = new File("Tempest.txt");
	private static String temp;

	public static void main(String[] args) {
		createString(tempest);
		temp = cleanup(temp);
		Scanner in = new Scanner(System.in);
		//		JOptionPane.showMessageDialog(null, "What word would you like to find in The "+tempest+"?");
		System.out.println("What word would you like to find in The "+tempest+"?");
		String s = new String(in.nextLine());
		//		String d = (String)JOptionPane.showInputDialog(
		//                null,
		//                "Type here???",
		//                "Input Please",
		//                JOptionPane.DEFAULT_OPTION,
		//                null,
		//                null,
		//                "ham");
		System.out.println("Searching for and counting number of times "+s+" appears.");
		int result = (searchThis(s));
		//		JOptionPane.showMessageDialog(null, "Found "+s+" "+result+" time(s).");
		System.out.println("Found "+s+" "+result+" time(s).");
		in.close();
	}
	public static int searchThis(String search){
		int r = 0;
		String se = new String(search);
		se= cleanup(se);
		System.out.println("searching: "+se);
		String [] availables = temp.split("\\s+");
		for (int i = 0; i<availables.length; i++){
			if (availables[i].equals(se)) {
				r++;
			}
		}
		return r;
	}
	public static void createString(File f) {
		String s = new String();
		try {
			Scanner txt = new Scanner(tempest);
			while (true) {
				try {
					s+= txt.nextLine(); 
					s+= " ";
				} catch (NoSuchElementException e) {
					break;
				}
			} 
			txt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp = s;
	}
	public static String cleanup(String s) {
		s= s.toLowerCase();
		s= s.replaceAll("[^a-z\\sA-Z]"," "); 
		return s;
	}
}
