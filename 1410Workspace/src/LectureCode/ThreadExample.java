// Fig. 23.4: PrintTask.java
// PrintTask class sleeps for a random time from 0 to 5 seconds
import java.util.Random;

public class ThreadExample implements Runnable 
{
   private final String taskName; // name of task
   private final static Random generator = new Random();
   private static final ThreadStorage threadStorage = new ThreadStorage(9);
   private final int startValue;
    
   public ThreadExample( String name, int startValue )
   {
      taskName = name; // set task name
      this.startValue = startValue;
   }

   public void sleepTest(){
	      try // put thread to sleep for sleepTime amount of time 
	      {
	    	 int sleepTime = generator.nextInt( 5000 ); // milliseconds
	         System.out.printf( "%s going to sleep for %d milliseconds.\n", taskName, sleepTime );
	         Thread.sleep( sleepTime ); // put thread to sleep
	      }        
	      catch ( InterruptedException exception )
	      {
	         System.out.printf( "%s %s\n", taskName,
	            "terminated prematurely due to interruption" );
	      }
	        
	      // print task name
	      System.out.printf( "%s done sleeping\n", taskName ); 
   }
   
   public void addTest(){ //This just adds 3 numbers into the array
	      for ( int i = startValue; i < startValue + 3; i++ )
	      {
	         threadStorage.add( taskName, i );
	      }
   }
   
   // method run contains the code that a thread will execute
   public void run()
   {
//	   sleepTest();
	   addTest();//Also uncomment the println at the end of Main
   }
   
   
   public static void main( String[] args )
   {
      System.out.println( "Creating threads" );

      // create each thread with a new targeted runnable
      Thread thread1 = new Thread( new ThreadExample( "task1", 1 ) );
      Thread thread2 = new Thread( new ThreadExample( "task2", 1 ) );
      Thread thread3 = new Thread( new ThreadExample( "task3", 1 ) );

      System.out.println( "Threads created, starting tasks." );

      // start threads and place in runnable state
      thread1.start(); // invokes task1’s run method
      thread2.start(); // invokes task2’s run method
      thread3.start(); // invokes task3’s run method

      
      System.out.println("Tasks Started, main could end, but it has added code that makes it wait");
      while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive()){
    	  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      }
      System.out.println(ThreadExample.threadStorage.toString());
      System.out.println( "Main ends" );
   }
   
}





/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/