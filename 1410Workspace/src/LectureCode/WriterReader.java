import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author
 *
 */
public class WriterReader {

	public static void main(String[] args) {
		String filename = "tmp.txt";
		writeRandomNumbersToFile(filename);
		sumIntsInFile(filename);
	}
	
	@SuppressWarnings("unused")
	public static void writeRandomNumbersToFile(String filename){
		Random rand = new Random();
		//Use a Formatter
		try {
			Formatter out  = new Formatter(filename);
		 
		for (int i = 0; i < 10; i++){
			int r = rand.nextInt(10);
			//Write r to the file
			out.format(Integer.toString(r)+" ");
		}
		out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void sumIntsInFile(String filename){
		int sum = 0;
		//Create a scanner
		try{
		File f = new File(filename);
		Scanner in = new Scanner(f);
		
		while( in.hasNext()){
		int n = in.nextInt();
		sum += n;
	    }
		System.out.println("The Sum Is: " + sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
