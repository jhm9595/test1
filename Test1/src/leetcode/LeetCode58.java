package leetcode;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * @author minibig
 *
 */
public class LeetCode58 {
	
	public static void main(String[] args) {
		lengthOfLastWord("a ");
	}
	
	public static int lengthOfLastWord(String s) {
		
		String[] strList = s.split(" ");
		
		if (strList.length == 0) return 0;

		return strList[strList.length - 1].length();
	}
}
