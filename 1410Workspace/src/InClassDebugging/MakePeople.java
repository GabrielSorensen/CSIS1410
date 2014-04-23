/**
 * 
 * @author Dr B
 *
 */
public class MakePeople {

	public static int findFirstNum(int numToFind, int[] a){
		System.out.println("Searching through the following array to find first occurrance of " + numToFind);
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for (int l = 0; l < a.length; l++){
			if(a[l] == numToFind){
				return 1;
			}
		}
		System.out.println("Value not found, returning -1");
		return -1;
	}
	
	public static void myFunMethod(){
		System.out.println("You are in the myFunMethod at line 1");
		for (int i = 200; i < 210; i++){
			System.out.println("You are in the myFunMethod at for loop value " + i);
		}
	}
	
	public static void main(String[] args) {

		myFunMethod();
		
		int x;
		x = 5;
		System.out.println("The value of x is " + x);
		x = 6;
		System.out.println("The value of x is " + x);

		Person one = new Person();
		System.out.println("Person ones stats");
		System.out.println(one.getFirstName());
		System.out.println(one.getLastName());
		System.out.println(one.getSocialSecurity());
		System.out.println(one.getPetsName());

		Person two = new Person("Harry" , "Potter", 1234567, "Hedwig");
		System.out.println("Person 2's first name is " + two.getFirstName());
		System.out.println("Person twos stats");
		System.out.println(two.getFirstName());
		System.out.println(two.getLastName());
		System.out.println(two.getSocialSecurity());
		System.out.println(two.getPetsName());
		
		int [] myArray = new int[10];
		for (int i = 0; i < myArray.length; i++){
			myArray[i] = (int)(Math.random()*5);
		}
		int f = findFirstNum(1,myArray);
		System.out.println("The first time 1 appears in the array is at location " + f);
		
	}

}
