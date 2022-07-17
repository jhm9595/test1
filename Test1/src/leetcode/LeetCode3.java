package leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author minibig
 *
 */
public class LeetCode3 {
	
	public static void main(String[] args) {
		lengthOfLongestSubstring("abcabcbb");
	}

	public static int lengthOfLongestSubstring(String s) {

//		01234567 
//		abcabcbb
//		a
//		ab
//		abc
//		 bca
//		  cab
//		   abc
//		     cb
//		       b

		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			System.out.println("i : " + i);
			if (map.containsKey(s.charAt(i))) {
				System.out.println("j : " + j);
				System.out.println("map.get(s.charAt(i)) + 1 : " + (map.get(s.charAt(i)) + 1));
				
				
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			System.out.println("(i, j) : (" + i + ", " + j + ") =>" + s.substring(j, i + 1));
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;

		/**
		 * 첫번째 제출 답안
		 */
//		char[] arr = s.toCharArray();
//		
//		int longestLength = 0;
//		
//		String currentString = "";
//		int leftIdx = 0;
//		for(int i = 0; i < arr.length; i++) {
//			
//			if(currentString.indexOf(arr[i]) >= 0) {
//				leftIdx += currentString.indexOf(arr[i]) + 1;
//				currentString = s.substring(leftIdx, i+1);
//			}else {
//				currentString = s.substring(leftIdx, i+1);
//			}
//			
//			if(longestLength < currentString.length()) {
//				longestLength = currentString.length();
//			}
//		}
//		return longestLength;

		/**
		 * 두번째 제출 답안
		 */
//		if(s.length() <= 1) return s.length();
//		
//		int l = 0;
//		
//		String str = String.valueOf(s.charAt(l));
//		int max = str.length();
//		String idxStr = "";
//		for(int i = 1; i < s.length(); i++) {
//			
//			idxStr = String.valueOf(s.charAt(i));
//			System.out.println("contains" + (str.contains(idxStr)));
//			if(str.contains(idxStr)) {
//				int idx = str.indexOf(idxStr);
//				l = i - (str.length() - idx) + 1;
//				str = s.substring(l, i+1);
//			}else {
//				str = str.concat(idxStr);
//				
//				if(str.length() > max) {
//					max = str.length();
//				}
//			}
//			
//
//			System.out.println("str : " + str);
//			
//		}
//		return max;

	}
}
