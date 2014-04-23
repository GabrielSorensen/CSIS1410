/**
 * 
 * @author
 *
 */
public class SurgeProtector {
	
	private ElectronicDevice [] surge;

	/**
	 * A new SurgeProtector has nothing plugged in and 20 open locations for ElectronicDevices
	 */
	public SurgeProtector(){
		surge  = new ElectronicDevice[20];
	}
	
	/**
	 * This method adds an Electronic device to the SurgeProtector
	 * @param e
	 * @return true if the device is added (20 ElectronicDevices total) and false otherwise
	 */
	public boolean addDevice(ElectronicDevice e){
		for (int i=0; i<surge.length; i++) {
			if (surge[i]==null) {
				surge[i] = e;
				return true;
			} 
		}
		return false;
	}

	/**
	 * 
	 * @return the number of devices added to the SurgeProtector
	 */
	public int getNumberOfDevicesPluggedIn(){
		int d = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i]!=null) {
				d++;
			}
		}
		return d;
	}

	/**
	 * 
	 * @return the number of Appliances added to the SurgeProtector
	 */
	public int getNumberOfAppliancesPluggedIn(){
		int d = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof Appliance) {
				d++;
			}
		}
		return d;
	}
	
	/**
	 * 
	 * @return the number of TVs added to the SurgeProtector
	 */
	public int getNumberOfTVsPluggedIn(){
		int d = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof TV) {
				d++;
			}
		}
		return d;
	}

	/**
	 * 
	 * @return the number of Refrigerators added to the SurgeProtector
	 */
	public int getNumberOfRefrigeratorsPluggedIn(){
		int d = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof Refrigerator) {
				d++;
			}
		}
		return d;
	}

	/**
	 * 
	 * @return the number of CellPhones added to the SurgeProtector
	 */
	public int getNumberOfCellPhonesPluggedIn(){
		int d = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof CellPhone) {
				d++;
			}
		}
		return d;
	}
	
	/**
	 * 
	 * @return the current usage of all devices plugged in
	 */
	public double getCurrentUsagePerSecond(){
		double u = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i]!=null) {
				u += surge[i].getCurrentUsagePerSecond();
			}
		}
		return u;
	}
	
	/**
	 * 
	 * @return the current usage of all Appliance devices plugged in
	 */
	public double getCurrentUsagePerSecondForAppliances(){
		double u = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof Appliance) {
				u += surge[i].getCurrentUsagePerSecond();
			}
		}
		return u;
	}

	/**
	 * 
	 * @return the current usage of all TV devices plugged in
	 */
	public double getCurrentUsagePerSecondForTVs(){
		double u = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof TV) {
				u += surge[i].getCurrentUsagePerSecond();
			}
		}
		return u;
	}
	
	/**
	 * 
	 * @return the current usage of all Refrigerator devices plugged in
	 */
	public double getCurrentUsagePerSecondForRefrigerators(){
		double u = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof Refrigerator) {
				u += surge[i].getCurrentUsagePerSecond();
			}
		}
		return u;
	}
	
	/**
	 * 
	 * @return the current usage of all CellPhone devices plugged in
	 */
	public double getCurrentUsagePerSecondForCellPhones(){
		double u = 0;
		for (int i=0; i<surge.length; i++) {
			if (surge[i] instanceof CellPhone) {
				u += surge[i].getCurrentUsagePerSecond();
			}
		}
		return u;
	}
		
}
