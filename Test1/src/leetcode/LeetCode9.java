package leetcode;

/*
 * https://leetcode.com/problems/palindrome-number/
 */
public class LeetCode9 {

	class Solution {
	    public boolean isPalindrome(int x) {
	        boolean result = false;
	        if(x < 0){
	            return result;
	        }else{
	            String str = String.valueOf(x);
	            
	            char l;
	            char r;
	            
	            for(int i = 0; i < str.length() / 2; i++){
	                l = str.charAt(i);
	                r = str.charAt(str.length() - 1 - i);
	                if(l != r){
	                    return result;
	                }
	            }
	            result = true;
	        }
	        
	        return result;
	    }
	}
}
