import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class WriteShakespear {

	private static File tempest = new File("Tempest.txt");
	private static ArrayList<String> avails = new ArrayList<String>();
	private static String [] a;
	private static Scanner in;

	public static void main(String[] args) {
		//make the lines available to look at in an array.
		getLines(tempest);
		//get the users input, You can also assume the input has proper capitalization and a period after the abbreviated name to make string comparisons easier. 
		in = new Scanner(System.in);
		System.out.println("What lines would you like to find in The "+tempest+"?");
		String s = new String(in.nextLine());
		//grab the user input and search through the string array for the lines
		System.out.println("Searching for lines for "+s+".");
		String result = getPart(s);
		//I print the results to the console, so I can check them 
		System.out.println(result);
		//and then I send the results to a file
		createPart(s, result);
		//always close resources.
		in.close();
	}
	public static void getLines(File f){
		
		//I take the lines and add them to an array list, and then convert it into a String array.
		//Take the file and split it into an array, mine is named a as an instance variable.
		//try and catch if things go wrong
		
		try {
			in = new Scanner(f);
			while (true) {
				try {
					avails.add(in.nextLine());
				} catch (NoSuchElementException e) {
					break;
				}
			}
			a= avails.toArray(new String[avails.size()]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String getPart(String s) {
		try {
			//result is the final string that we will write to the file later, j is the line counter, and checking is  for a while loop;
			String result = new String();
			int j = 0;
			boolean checking = true;
			av:      //this is a break point loop marker, 
				for (int i=0; i<a.length; i++) {
					if (a[i].contains(s)) {
						while (checking) {
							if (a[i+j].equals("")) {   //adds lines from the string array until there is an empty string (a line with no words, signaling that the part is over)
								i = i+j+1;
								j = 0;
								continue av;   // this continues searching  the rest of the string array so that we don't just get the first lines that are in the document, it goes to the av marker earlier and continues the for loop
							} else {
								result+=a[i+j];
								result+="\n";   //puts an empty line between parts so that reading is easier
								j++;
							}
						}
					}
				}
			return result;			//give a giant string filled with all of the lines
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}
	public static void createPart(String name, String content) {
		try{
			// name is the name of the file that will be written, and content is the stuff that we got from searching the string array for lines
			//
			Formatter out = new Formatter(name);
			out.format(content);
			out.close();
			//close the resources and write the file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
