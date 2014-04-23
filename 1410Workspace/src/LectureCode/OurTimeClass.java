/**
 * 
 * @author Dr. B.
 *
 */
public class OurTimeClass {

	private int hour;   //0 - 23
	private int minute; //0 - 59
	private int second; //0 - 59
	
	public void setTime(int h, int m, int s){
		hour = h;
		minute = m;
		second = s;

	}
	//Military time HH:MM:SS
	public String toUniversalString(){
		return String.format( "%02d:%02d:%02d", hour, minute, second);
	}
	
	//Regular Time H:MM:SS: AM or PM
	public String toString(){
		int h = hour;
		if (h == 0){
			h = 12;// 0 should read 12 in regular time
		}

		if (hour < 12){
			return String.format( "%02d:%02d:%02d AM", h, minute, second);
		}
		else{
			return String.format( "%02d:%02d:%02d PM", h%12, minute, second);
		}
	}
	
	public static void main(String[] args) {

		OurTimeClass time = new OurTimeClass();
		
		System.out.print("The initial universal time is: " );
		System.out.println(time.toUniversalString());
		System.out.print("The initial standard time is: ");
		System.out.println(time.toString());
		System.out.println();
		
		time.setTime(13,27,6);
		System.out.print("Universal time after setTime is: " );
		System.out.println(time.toUniversalString());
		System.out.print("Standard time after setTime is: ");
		System.out.println(time.toString());
		System.out.println();
		
		//Use invalid times
		time.setTime(99, 99, 99);
		System.out.println("After attempting invalid settings: ");
		System.out.print("Universal time after setTime is: " );
		System.out.println(time.toUniversalString());
		System.out.print("Standard time after setTime is: ");
		System.out.println(time.toString());
		System.out.println();
		
		
		
		
		
		/*
		//Make 50 more objects.
		 for (int i = 0; i < 50; i++){
				OurTimeClass t = new OurTimeClass(1,1,1);
		 }
		 int x = time.getNumOfTimeObjectsCreated();
		 System.out.println("There are now a total of " + x + " time objects (should be 50");
		*/
		
	}

}
