/**
 * 
 * @author 
 *
 */
public class Sink {

	/**
	 * This is the no argument constructor.
	 * When an sink is created using this constructor it has no water in it
	 * and a brand name of Barker
	 * and a max water volume limit of 100 liters 
	 * 
	 */
	
	private int volume;
	private int volumeInUse;
	private String brand;
	
	public Sink(){
		this.brand = "Barker";
		this.volume = 100;
		this.volumeInUse = 0;
	}
	
	/**
	 * This is the 2 argument constructor.
	 * When an sink is created using this constructor it has no water in it
	 * and a brand name of brandName (the parameter)
	 * and a max water volume of volumnLimit (the parameter)

	 * @param brandName, the name used for the brand
	 * @param volumeLimit, the volume Limit for the sink
	 * 
	 * GOTCHAS.  If the volumeLimit is negative, set the limit to 0
	 */
	public Sink(String brandName, int volumeLimit){
		if (brandName==null) {
			this.brand = "Barker";
		} else {
			this.brand = brandName;
		}
		if (volumeLimit<0) {
			this.volume = 0;
		} else {
			this.volume = volumeLimit;
		}
		this.volumeInUse = 0;
	}
	
	/**
	 * Sets (changes) the brand name of the sink
	 * @param name
	 * 
	 */
	public void setBrandName(String name){
		if (name==null) {
			this.brand = "Barker";
		} else {
			this.brand = name;
		}
	}

	/**
	 * 
	 * @returns the current brand name of the sink
	 *
	 */
	public String getBrandName(){
		return this.brand;
	}

	
	/**
	 * 
	 * Changes (sets) the max volume limit
	 * 
	 * @param maxVolume is the new max volume for the sink
	 * 
	 * GOTCHAS:  Only set the max volume to the new value if the new value is positive
	 */
	public void setMaxWaterVolume(int maxVolume){
		if (maxVolume>0) {
			this.volume = maxVolume;
		}
	}
	
	/**
	 * 
	 * @return the current max water volume
	 */
	public int getMaxWaterVolume(){
		return this.volume;
	}
	
	
	/**
	 * 
	 * @return The current volume of water in the sink
	 */
	public int getCurrentVolumnOfWaterInSink(){
		return this.volumeInUse;
	}

	
	/**
	 * adds more water (liters) into the sink 
	 * @param liter is the amount of extra water added
	 * 
	 * Gotchas:  Only add liter if the value given is positive, otherwise do not change the water level in the sink
	 * 
	 */
	public void addWater(int liter){
		if (liter<0) {
			this.volumeInUse +=0;
		} else {
			this.volumeInUse += liter;
		}
	}
	

	/**
	 * drains / removes water (liters) from the sink 
	 * @param liter is the amount of water to be drained / removed
	 * 
	 * Gotchas:  Only drain liter if the value given is positive, otherwise do not change the water level in the sink
	 * Gotchas:  Do not let the water level go negative, just put it to 0 if it does
	 * 
	 */
	public void drainWater(int liter){
		if (liter>0) {
			if (liter>this.volumeInUse) {
				this.volumeInUse = 0;
			} else {
				this.volumeInUse -= liter;
			}
		} else {
			this.volumeInUse +=0;
		}
	}

	

	/**
	 * 
	 * @return true if there is too much water in the sink, false otherwise  
	 */
	public boolean isOverFlowing(){
		if (this.volume<this.volumeInUse) {
			return true;
		} else {
			return false;
		}
	}

	
		
	
}
