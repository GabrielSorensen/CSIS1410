/**
 * 
 * @author Dr B
 * 
 * NOTE: You should not edit this file for the assignment
 *
 */
public class CellPhone extends ElectronicDevice {

	private int hoursUntilFullCharge;
	
	/**
	 * 
	 * 
	 * @param wattsUsedPerHour is the amount of watts used when charging the device per hour
	 * @param hoursUntilFullCharge is the amount of hours from a dead
	 *        battery until the battery is full using a charger
	 */
	public CellPhone(double wattsUsedPerHour, int hoursUntilFullCharge){
		super(wattsUsedPerHour);
		this.hoursUntilFullCharge = 0;
		if(hoursUntilFullCharge > 0){
			this.hoursUntilFullCharge = hoursUntilFullCharge;
		}
	}
	
	public int getNumHoursUntilFullCharge(){
		return this.hoursUntilFullCharge;
	}
	

}
