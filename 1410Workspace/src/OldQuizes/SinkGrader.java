/**
 * This is the code that I will used to grade your Sink.java file
 *  
 * @author Dr. B.
 *
 */
public class SinkGrader {

	public static void main(String[] args) {
		int points = 100;
		int deduction = 100/11;

		//Test the no argument constructor and the getters
		Sink blank15 = new Sink();
		if (blank15.getMaxWaterVolume() != 100 || blank15.getCurrentVolumnOfWaterInSink() != 0 || blank15.getBrandName() != "Barker"){
			System.err.println("Creating a new Sink using the no argument constructor should have a volume limit of 100, a current volume of 0, and a brand name of 'Barker'.  This error could also be caused by your getter methods not returning the correct values");
			points -= deduction;
		}
		Sink constructed32 = new Sink("Dr B's Cool Sink", 3000);
		if (constructed32.getMaxWaterVolume() != 3000 || constructed32.getCurrentVolumnOfWaterInSink() != 0 || constructed32.getBrandName() != "Dr B's Cool Sink"){
			System.err.println("Creating a new Sink using the 2 argument constructor should have a current volume of 0, a volume limit of what was passed as a parameter, and a name of what was passed as a parameter.  This error could also be caused by your getter methods not returning the correct values");
			points -= deduction;
		}
		
		//Try changing the brand name
		String brandName1 = "SUU T Birds";
		String brandName2 = "Computer Geek";
		Sink a1 = new Sink();
		Sink a2 = new Sink();
		a1.setBrandName(brandName1);
		a2.setBrandName(brandName2);
		String a1s = a1.getBrandName();
		String a2s = a2.getBrandName();
		if (!a1s.equals(brandName1) || !a2s.equals(brandName2)){
			System.err.println("The brand name is set and retreived incorrectly");
			points -= deduction;
		}
		
		//Try changing the volume limit
		int volume1 = (int) (Math.random() * 8769);
		a1.setMaxWaterVolume(volume1);
		if (a1.getMaxWaterVolume() != volume1){
			System.err.println("The volume limit is set and retreived incorrectly");
			points -= deduction;
		}
		
		//Try changing the volume limit to a negative number
		int badValue = (int) (Math.random()* 59305 * -1);
		a1.setMaxWaterVolume(badValue);
		if (a1.getMaxWaterVolume() != volume1){
			System.err.println("The volume limit is set and retreived incorrectly on a negative value");
			points -= deduction;
		}
		
		
		

		int volume10 = 10;
		int volume15 = 15;
		Sink e10 = new Sink();
		Sink e15 = new Sink();
		e10.addWater(volume10);
		e15.addWater(volume10);
		e15.addWater(volume15);
		int p10 = e10.getCurrentVolumnOfWaterInSink(); 
		int p15 = e15.getCurrentVolumnOfWaterInSink(); 
		if(p10 != volume10 || p15 != volume10 + volume15){
			System.err.println("The addWater method incorrectly adds volume");
			points -= deduction;
		}

		e10.addWater(-1*volume10);
		e15.addWater(-1*volume15);
		p10 = e10.getCurrentVolumnOfWaterInSink(); 
		p15 = e15.getCurrentVolumnOfWaterInSink(); 
		if(p10 != volume10 || p15 != volume10 + volume15){
			System.err.println("The addWater method incorrectly sets volumes on negative values");
			points -= deduction;
		}
		
		
		int volume20 = 20;
		Sink hp10 = new Sink();
		hp10.addWater(volume20 * 3);
		hp10.drainWater(volume20);
		int grw = hp10.getCurrentVolumnOfWaterInSink();
		if(grw != volume20*2){
			System.err.println("The drainWater method incorrectly drains volumes");
			points -= deduction;
		}

		hp10.drainWater(-1*volume20);
		grw = hp10.getCurrentVolumnOfWaterInSink(); 
		if(grw != volume20*2){
			System.err.println("The drainWater method incorrectly drains volumes on negative values");
			points -= deduction;
		}
		
		hp10.drainWater(volume20 * 50);
		grw = hp10.getCurrentVolumnOfWaterInSink(); 
		if(grw != 0){
			System.err.println("The drainWater method does not 0 out when the volume drained is too large");
			points -= deduction;
		}
		
		
		Sink mns = new Sink();
		boolean underLimit = mns.isOverFlowing();
		mns.addWater(400);
		boolean overLimit = mns.isOverFlowing();
		if (underLimit != false || overLimit != true){
			System.err.println("The isOverFlowing method does not return true and false correctly");
			points -= deduction;
		}
		
		
		if(points == 1){
			points--;
		}
		System.out.println("Your graded percentage for this assignment is: " + points);
	}

}
