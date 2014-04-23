/**
 * 
 * @author
 * @version
 *
 */

public class Mystery {
	/**
	 * Explain without using recursive language what this method does?
	 */
	public static int mystery1( int a, int b ){ //returns a*b
		if (b == 1){						
			return a;
		}
		else{
			return a + mystery1(a, b-1);
		}
	}

	/**
	 * Explain without using recursive language what this method does?
	 */
	public static int mystery2 (int array[], int size){ //returns the sum of the numbers from the beginning of the array to the size variable.
		if (size == 1){
			return array[0];
		}
		else{
			return array[size-1] + mystery2(array, size-1);
		}
	}

	/**
	 * Explain without using recursive language what this method does?
	 */
	public static String mystery3 (int array[], int x){ //returns the values of the array from the ending point to [] spot x.
		if (x < array.length){
			return mystery3(array, x+1) + "" + array[x] + " ";
		}
		else{
			return "";
		}
	}


	public static void main(String[] args){

		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int b[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int c[] = {1, 5, 3, 7, 8, 5, 9, 4, 10, 6};

		int x = mystery1(4,4);
		System.out.println("mystery1 says " + x);
		
		for (int i=1; i<6; i++) {
			x = mystery2(a,i);
			System.out.println("mystery2 says '" + x + "' with array a");
			x = mystery2(b,i);
			System.out.println("mystery2 says '" + x + "' with array b");
		}
		
		String s = mystery3(c,6);
		System.out.println("mystery3 says '" + s + "' with array c");
		s = mystery3(b,9);
		System.out.println("mystery3 says '" + s + "' with array b");
	}

}