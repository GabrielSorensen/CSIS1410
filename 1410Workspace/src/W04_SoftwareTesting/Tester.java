/**
 * 
 * @author
 *
 */
public class Tester {
	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();
		System.out.println("Preforming test #1");
		if (subractInt()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Preforming test #2");
		if (addInt()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Preforming test #3");
		if (addICNumber()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Preforming test #4");
		if (setCurrentValue()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Preforming test #5");
		if (getCurrentValueSlashConstructor()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Preforming test #6");
		if (compare()==false) {
			wait(1000);
			System.err.println("Sir, this test failed, hard.");
		} else {
			wait(1000);
			System.out.println("Done.");
		}
		System.out.println("Sir, we have completed all your required tests. Time to view the results.");


	}
	public static boolean subractInt() {
		int test = 0;
		System.out.println("Lets test this bro.");
		MyIC CCCCC = new MyIC(0);
		for (int i=-100; i==100; i++) {
			test -= i;
			CCCCC.subtract(i);
			if (test!=CCCCC.getCurrentValue()) {
				System.err.println("Sir, there was an error processing: "+i);
				return false;
			}
		}
		return true;
	}
	public static boolean addInt(){
		int test = 0;
		System.out.println("Lets test this homie.");
		MyIC CCCCC = new MyIC(0);
		for (int i=-100; i==100; i++) {
			test += i;
			CCCCC.add(i);
			if (test!=CCCCC.getCurrentValue()) {
				System.err.println("Sire, there was an error at: "+i);
				return false;
			}
		}
		return true;
	}
	public static boolean addICNumber() {
		int test = 0;
		System.out.println("Lets test this dawg.");
		MyIC CCCCC = new MyIC(0);
		for (int i=-100; i==100; i++) {
			MyIC D = new MyIC(i);
			test += i;
			CCCCC.add(D);
			if (test!=CCCCC.getCurrentValue()) {
				System.err.println("error: "+i);
				return false;
			}
		}
		return true;
	}
	public static boolean setCurrentValue() {
		System.out.println("Lets test this brohemoth.");
		MyIC CCCCC = new MyIC(0);
		for (int i=-100; i<=100; i++) {
			CCCCC.setCurrentValue(i);
			if (CCCCC.getCurrentValue()!=i) {
				System.err.println("Found an error boss. #: "+i);
				System.out.println("iteration: "+i);
				System.out.println("number: "+CCCCC.getCurrentValue());
				return false;
			}
		}
		return true;
	}
	public static boolean getCurrentValueSlashConstructor(){
		System.out.println("Lets test this broseph.");
		for (int i=-100; i<=100; i++) {
			MyIC CCCCC = new MyIC(i);
			if (CCCCC.getCurrentValue()!=i) {
				System.err.println("Found an error boss. #: "+i);
				return false;
			}
		}
		return true;
	}
	public static boolean compare() {
		System.out.println("Time to test this one too.");
		wait(1000);
		MyIC O = new MyIC(0);
		if (O.compare(-100)!=-1) {
			System.err.println("Sir, this doesn't work as expected.");
			System.err.println("Broke on less than.");
			return false;
		} else if (O.compare(0)!=0) {
			System.err.println("Sir, this doesn't work as expected.");
			System.err.println("Broke on equal to.");
			return false;
		} else if (O.compare(100)!=1) {
			System.err.println("Sir, this doesn't work as expected.");
			System.err.println("Broke on greater than.");
			return false;
		} else {
			return true;
		}
	}
	public static void wait(int mills){
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}