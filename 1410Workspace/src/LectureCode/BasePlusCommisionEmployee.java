// Fig. 9.4: CommissionEmployee.java
// CommissionEmployee class represents a commission employee.

public class BasePlusCommisionEmployee extends CommissionEmployee {

	private double baseSalary;
	
	public BasePlusCommisionEmployee( String first, String last, String ssn, double sales, double rate, double base )
	{	
		super(first, last, ssn, sales, rate);
		setBaseSalary(base);
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		if (baseSalary>=0) {
		this.baseSalary = baseSalary;
		}
	}
	public double earnings()
	{
		return super.earnings() + baseSalary;
	}

	public String toString()
	{
		return String.format( super.toString()+ "\nBase Salary "+baseSalary);
	}

	public static void main(String args[]){
		CommissionEmployee employee1 = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06 );

		System.out.println( "Employee information obtained by get methods: \n" );
		System.out.printf( "%s %s\n", "First name is", employee1.getFirstName() );
		System.out.printf( "%s %s\n", "Last name is",  employee1.getLastName() );
		System.out.printf( "%s %s\n", "Social security number is", employee1.getSocialSecurityNumber() );
		System.out.printf( "%s %.2f\n", "Gross sales is", employee1.getGrossSales() );
		System.out.printf( "%s %.2f\n", "Commission rate is", employee1.getCommissionRate() );

		employee1.setGrossSales( 500 );
		employee1.setCommissionRate( .1 );

		System.out.printf( "\n%s:\n\n%s\n", "Updated employee information obtained by toString", employee1 );

		
	      // instantiate BasePlusCommissionEmployee object
	      BasePlusCommisionEmployee employee2 = new BasePlusCommisionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300 );

	      // get base-salaried commission employee data
	      System.out.println( "Employee information obtained by get methods: \n" );
	      System.out.printf( "%s %s\n", "First name is", employee2.getFirstName() );
	      System.out.printf( "%s %s\n", "Last name is", employee2.getLastName() );
	      System.out.printf( "%s %s\n", "Social security number is", employee2.getSocialSecurityNumber() );
	      System.out.printf( "%s %.2f\n", "Gross sales is", employee2.getGrossSales() );
	      System.out.printf( "%s %.2f\n", "Commission rate is", employee2.getCommissionRate() );
	      System.out.printf( "%s %.2f\n", "Base salary is", employee2.getBaseSalary() );

	      employee2.setBaseSalary( 1000 ); // set base salary

	      System.out.printf( "\n%s:\n\n%s\n", "Updated employee information obtained by toString", employee2.toString() );
		 



		//Leave this commented out until a Chap 10 lecture
		//BasePlusCommissionEmployee bplus = new BasePlusCommissionEmployee("Robert", "Jordan", "555-55-5555", 50000, .06, 3000);
		//CommissionEmployee poly = bplus; //bplus is a BasePlusComissionEmployee
		//System.out.println("\n\nPolymorphism Test");
		//System.out.println(poly.toString());


	}


}
