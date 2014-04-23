import java.util.Scanner;

/**
 * 
 * @author
 *
 */
public class ExceptionExamples {

	public static int divide(int a, int b){
		int x = a / b;
		return x;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number for division: ");
		int userNumber = in.nextInt();
		int i = divide(5,userNumber);
		System.out.println("divide returned " + i);
		in.close();
	}

}
