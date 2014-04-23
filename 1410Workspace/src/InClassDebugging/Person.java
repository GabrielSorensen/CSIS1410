/**
 * 
 * @author Dr B
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private int socialSecurity;
	private String petsName;
	
	public Person(){
		this("Dr", "B", 5555555, "Pigwidgeon");
	}

	public Person(String f, String l,int s, String p){
		firstName = f;
		lastName = l;
		socialSecurity = s;
		petsName = p;
		System.out.println("Making a new person with " + firstName + " " + lastName + " " + socialSecurity + " " + petsName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(int socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public String getPetsName() {
		return petsName;
	}

	public void setPetsName(String petsName) {
		this.petsName = petsName;
	}

}
