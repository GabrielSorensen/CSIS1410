// Fig. 9.4: CommissionEmployee.java
// CommissionEmployee class represents a commission employee.

public class CommissionEmployee
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private double grossSales; // gross weekly sales
   private double commissionRate; // commission percentage

   public CommissionEmployee( String first, String last, String ssn, double sales, double rate )
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
      setGrossSales( sales ); // validate and store gross sales
      setCommissionRate( rate ); // validate and store commission rate
   }

   public void setFirstName( String first )
   {
      firstName = first;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setLastName( String last )
   {
      lastName = last;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn; //TODO: validate this
   }

   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   }

   public void setGrossSales( double sales )
   {
      grossSales = 0.0;
      if ( sales > 0.0 ){
    	  grossSales = sales;
      }
   }

   public double getGrossSales()
   {
      return grossSales;
   }

   public void setCommissionRate( double rate )
   {
      commissionRate = 0.0;
      if ( rate > 0.0 && rate < 1.0 ){
    	  commissionRate = rate;
      }
   }

   public double getCommissionRate()
   {
      return commissionRate;
   }

   public double earnings()
   {
      return commissionRate * grossSales;
   }

   public String toString()
   {
      return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", 
         "commission employee", firstName, lastName, 
         "social security number", socialSecurityNumber, 
         "gross sales", grossSales, 
         "commission rate", commissionRate );
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
	      
	      /*
	      // instantiate BasePlusCommissionEmployee object
	      BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300 );
	      
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
	      */

	      
	      
	      //Leave this commented out until a Chap 10 lecture
	      BasePlusCommisionEmployee bplus = new BasePlusCommisionEmployee("Robert", "Jordan", "555-55-5555", 50000, .06, 3000);
	      CommissionEmployee poly = bplus; //bplus is a BasePlusComissionEmployee
	      BasePlusCommisionEmployee childAgain = (BasePlusCommisionEmployee) poly;
	      System.out.println("\n\nPolymorphism Test");
	      System.out.println(poly.toString());

	      
   }
   
   
}
