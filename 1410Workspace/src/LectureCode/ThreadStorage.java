// Fig. 23.7: SimpleArray.java
// Class that manages an integer array to be shared by multiple threads.
import java.util.Random;

public class ThreadStorage
{
   private final int array[]; // an integer array - Because there is only 1 object created, this is shared
   private int writeIndex = 0; // index of next element to be written
   private final static Random generator = new Random();

   public ThreadStorage( int size )
   {
      array = new int[ size ];
   }

   // add a value to the shared array
   public void add( String name, int value )
   {
      int position = writeIndex; // store the write index

      try
      {
         // put thread to sleep for 0-499 milliseconds
         Thread.sleep( generator.nextInt( 500 ) ); 
      }
      catch ( InterruptedException ex )
      {
         ex.printStackTrace();
      }

      // put value in the appropriate element
      array[ position ] = value;
      System.out.printf( "%s or '%s' wrote %2d to element %d.\n", 
         Thread.currentThread().getName(), name, value, position );

      ++writeIndex; // increment index of element to be written next
      System.out.printf( "Next write index: %d\n", writeIndex );
   }
   
   // used for outputting the contents of the shared integer array
   public String toString()
   {
      String arrayString = "\nContents of SimpleArray:\n";
   
      for ( int i = 0; i < array.length; i++ )
         arrayString += array[ i ] + " ";
   
      return arrayString;
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