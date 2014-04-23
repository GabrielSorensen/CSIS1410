/**
 * 
 * @author Dr B
 * 
 * NOTE: You should not edit this file for the assignment
 *
 */
public abstract class ElectronicDevice {

	private double wattsPerHour;

	/**
	 * 
	 * @param wattsUsedPerHour is the amount of watts used by the device per hour
	 */
	public ElectronicDevice(double wattsUsedPerHour){
		wattsPerHour = 0;
		if (wattsUsedPerHour > 0){
			wattsPerHour = wattsUsedPerHour;
		}
	}
	public double getCurrentUsagePerSecond(){
		return wattsPerHour/60/60; //60 minutes per hour, and 60 seconds per minute
	}
}
