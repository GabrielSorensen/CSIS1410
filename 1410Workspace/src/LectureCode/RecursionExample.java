
public class RecursionExample {

	public static void main(String[] args) {
	
	}
	public static long factorial(long n) {
		if (n <= 1) {
			return 1l; //base case
		} else {
			return n*factorial(n-1l); //recursive case
		}
	}
	public static long fact(long n) {
		long answer = 1;
		for (long i=n; i>=1; i--) {
			answer = answer* i;
		}
		return answer;
	}
	public static long fibbonachi(long n) {
		if (n <= 0) {
			return n;
		} else if (n == 1) {
			return 1;
		}else {
			return fibbonachi(n-1)+fibbonachi(n-2);
		}
	}
	public static void infiniterecursion(int i) {
		System.out.println(i);
		infiniterecursion(i+1);
	}
	public static void infinite(int i) {
		while(true) {
			System.out.println(i);
			i++;
		}
	}
	
}
