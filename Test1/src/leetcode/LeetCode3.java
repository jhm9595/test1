package leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author minibig
 *
 */
public class LeetCode3 {

	public int lengthOfLongestSubstring(String s) {

//		abcabcbb
//		a
//		ab
//		abc
//		 bca
//		  cab
//		   abc
//		     cb
//		       b

		char[] arr = s.toCharArray();
		
		int longestLength = 0;
		
		String currentString = "";
		int leftIdx = 0;
		for(int i = 0; i < arr.length; i++) {
			
			if(currentString.indexOf(arr[i]) >= 0) {
				leftIdx += currentString.indexOf(arr[i]) + 1;
				currentString = s.substring(leftIdx, i+1);
			}else {
				currentString = s.substring(leftIdx, i+1);
			}
			
			if(longestLength < currentString.length()) {
				longestLength = currentString.length();
			}
		}
		return longestLength;
	}
}
