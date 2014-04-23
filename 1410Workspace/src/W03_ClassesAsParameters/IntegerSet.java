
/**
 * 
 * @author
 * @version
 *
 */
public class IntegerSet {

	/**
	 * This is the no argument constructor.  You need to represent an empty integer set with this constructor
	 */
	public IntegerSet(){
		
	}
	
	/**
	 * This constructor takes a boolean array a as an argument.
	 * All items in the array need to be copied.
	 * Do not just perform a shallow copy. 
	 * @param a
	 */
	public IntegerSet(boolean [] a){
		
	}
	
	/**
	 * This Constructor takes a different integer set as a parameter.
	 * 
	 * @param a is the integer set you want to pattern your current object after.
	 * In other words, the current object should be a copy of a.
	 * All items in a need to be copied.  Do not just perform a shallow copy.
	 */
	public IntegerSet(IntegerSet a){
		
	}
	
	/**
	 * This method should not change a or b
	 * 
	 * @param a the first IntegerSet
	 * @param b the second IntegerSet
	 * @return a third integer set that represents the union of a and b
	 * 
	 * A union is defined as all elements are set to true in the new IntegerSet
	 * if they are in either or both a or b and set to false otherwise
	 */
	public static IntegerSet union(final IntegerSet a, final IntegerSet b){
		return null;
	}
	
	/**
	 * This method unions b to the current object
	 * 
	 * @param b
	 * 
	 * A union in this case means, using the current object,
	 * leave all things true that currently are true and
	 * set to true all things that are true in b
	 */
	public void union(final IntegerSet b){
		
	}
	
	/**
	 * This method should not change a or b
	 * 
	 * @param a the first IntegerSet
	 * @param b the second IntegerSet
	 * @return a third integer set that represents the intersection of a and b.
	 * 
	 * An intersection is defined as an element is true in the new set if it is true in
	 * both the a and b sets.  It is false otherwise.
	 */
	public static IntegerSet intersect(final IntegerSet a, final IntegerSet b){
		return null;
	}
	
	/**
	 * This method intersects b with the current object
	 * 
	 * @param b
	 * 
	 * An intersection in this case means, using the current object,
	 * Only leave elements true if they are true in both the current 
	 * and b sets.
	 */
	public void intersect(final IntegerSet b){
		
	}
	
	/**
	 * @return a string containing all elements that are true.
	 * For example, if spot 10 and 99 were true and everything else was false
	 * the string returned would be 10 99 
	 * 
	 * Note: Add a space after each item, including the last item in the list.
	 * Note: return "" for an empty set
	 */
	public String toString(){
		return "-1";
	}
}
