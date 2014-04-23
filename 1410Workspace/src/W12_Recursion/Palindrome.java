/**
 * 
 * @author
 * @version
 *
 */

public class Palindrome {
	/**
	 *
	 *To solve this, you might want to look at
	 *the s.substring and s.length methods
	 */
	//	public static boolean testPalindrome2(String s){                    <---This is personally how I would have done it.
	//		String e = s.replaceAll("[^a-zA-Z0-9\\s]", "");
	//		e = e.replaceAll(" ", "");
	////		System.out.println(s);
	//		String r = new String();
	//		for (int i=0; i<e.length(); i++) {
	//			r = e.charAt(i)+r;
	//		}
	////		System.out.println(r);
	//		if (e.equalsIgnoreCase(r)){
	//			return true;
	//		} else {
	//			return false;
	//		}
	//	}
	public static boolean testPalindrome(String s) {
		String invalid = ",./;'[]-= ";
		try {
			if (s.length()==1) {
				return true;
			} else if (s.charAt(0)==invalid.charAt(0) || s.charAt(0)==invalid.charAt(1) || s.charAt(0)==invalid.charAt(2) || s.charAt(0)==invalid.charAt(3) || s.charAt(0)==invalid.charAt(4) || s.charAt(0)==invalid.charAt(5) || s.charAt(0)==invalid.charAt(6) || s.charAt(0)==invalid.charAt(7) || s.charAt(0)==invalid.charAt(8) || s.charAt(0)==invalid.charAt(9)) {
				return testPalindrome(s.substring(1, s.length()));
			} else if (s.charAt(s.length()-1)==invalid.charAt(0) || s.charAt(s.length()-1)==invalid.charAt(1) || s.charAt(s.length()-1)==invalid.charAt(2) || s.charAt(s.length()-1)==invalid.charAt(3) || s.charAt(s.length()-1)==invalid.charAt(4) || s.charAt(s.length()-1)==invalid.charAt(5) || s.charAt(s.length()-1)==invalid.charAt(6) || s.charAt(s.length()-1)==invalid.charAt(7) || s.charAt(s.length()-1)==invalid.charAt(8) || s.charAt(s.length()-1)==invalid.charAt(9)) {
				return testPalindrome(s.substring(0, s.length()-1));
			} else if (s.charAt(0)==s.charAt(s.length()-1)) {
				return testPalindrome(s.substring(1, s.length()-1));
			}
		} catch (StringIndexOutOfBoundsException e) {
			return true;
		}
		return false;
	}
}