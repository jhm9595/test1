package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author minibig
 *
 */
public class LeetCode7 {
	
	static String INT_MIN = String.valueOf(Integer.MIN_VALUE).substring(1);
	
	static String INT_MAX = String.valueOf(Integer.MAX_VALUE);
	
	public static int reverse(int x) {
		 
		StringBuilder sb = new StringBuilder();
		 
        if(x < 0){
        	
            String x_str_plus = String.valueOf(x).substring(1);
            
            for(int i = x_str_plus.length()- 1; i >= 0; i--) {
            	sb.append(x_str_plus.charAt(i));
            }
            
            String reverse_Str = sb.toString();
            
            if(lpad(reverse_Str).compareTo(INT_MIN) > 0) {
            	return 0;
            }else {
            	return -1 * Integer.valueOf(reverse_Str);
            }
        }else{
        	String x_str = String.valueOf(x);
            
            for(int i = x_str.length()- 1; i >= 0; i--) {
            	sb.append(x_str.charAt(i));
            }
            
            String reverse_Str = sb.toString();
            
            if(lpad(reverse_Str).compareTo(INT_MAX) > 0) {
            	return 0;
            }else {
            	return Integer.valueOf(reverse_Str);
            }
        }
    }
	 
	 public static String lpad(String value) {
		 for(int i = 0 ; i < 10 - value.length(); i++) {
			 value = "0" + value;
		 }
		 return value;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(reverse(-123));
		 
	 }
}
