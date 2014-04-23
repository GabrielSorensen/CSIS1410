
public class tester2 {

	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();
			System.out.println("Preforming test #1");
				if (subractInt()==false) {
					System.err.println("Sir, this test failed, hard.");
				} else {
					System.out.println("Done.");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Preforming test #2");
				if (addInt()==false) {
					System.err.println("Sir, this test failed, hard.");
				} else {
					System.out.println("Done.");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Preforming test #3");
				if (addICNumber()==false) {
					System.err.println("Sir, this test failed, hard.");
				} else {
					System.out.println("Done.");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Preforming test #4");
				if (setCurrentValue()==false) {
					System.err.println("Sir, this test failed, hard.");
				} else {
					System.out.println("Done.");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Preforming test #5");
				if (getCurrentValueSlashConstructor()==false) {
					System.err.println("Sir, this test failed, hard.");
				} else {
					System.out.println("Done.");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Sir, we have completed all your required tests.");
				
		
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
}
