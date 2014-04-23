/**
 * 
 * @author Dr B
 *
 */
public class ZW11_Grader {
	public static void main(String [] args){
		new Home(new Plug(99), new Plug(99), new Refrigerator(99), new SolarPanel(1), new SolarPanel(1), new Battery(99));
		
		Home h2 = new Home(new Plug(1), new Plug(50), new Refrigerator(1), new SolarPanel(99), new SolarPanel(50), new Battery(1));
		h2.setLocation(50, 50);
	}
}
