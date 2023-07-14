package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author minibig
 *
 */
public class LeetCode5 {
	
	public String longestPalindrome(String s) {
		
		if(s.length() <= 1) {return s;}
		
		String result = s.substring(0,1);
		
		List<Position_LeetCode5> palindromeList = new ArrayList<Position_LeetCode5>();
		
		for(int i = 0; i < s.length(); i++) {
			if(i+2 <= s.length() && isPalindrome(s.substring(i,i+2))) {
				palindromeList.add(new Position_LeetCode5(i, i+2));
			}
			if(i+3 <= s.length() && isPalindrome(s.substring(i,i+3))) {
				palindromeList.add(new Position_LeetCode5(i, i+3));
			}
		}
		
		for(Position_LeetCode5 item : palindromeList) {
			int l = item.getStart();
			int r = item.getEnd();
			boolean stillPalindrome = true;
			String str = "";
			while(stillPalindrome && l >=0 && r <= s.length()) {
				str = s.substring(l,r);
				if(s.charAt(l) == s.charAt(r-1)) {
					if(str.length() > result.length()) {
						result = str;
					}
				}else {
					stillPalindrome = false;
				}
				l--;
				r++;
			}
		}
		return result;
	}

	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		if (s.length() == 1)
			return isPalindrome;

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return isPalindrome;
	}
}

class Position_LeetCode5 {
	
	private int start;
	private int end;
	
	public Position_LeetCode5(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
}

