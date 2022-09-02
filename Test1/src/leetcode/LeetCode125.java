package leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author minibig
 *
 */
public class LeetCode125 {

	public boolean isPalindrome(String s) {
		
		boolean result = true;
		
		char[] arr = s.toCharArray();
		int len = s.length();
		int rightIdx = len - 1;
		for(int i = 0; i < len/2; i++) {
			if(arr[i] <'a' || arr[i] > 'z') {
				continue;
			}
			
			if(arr[rightIdx] <'a' || arr[rightIdx] > 'z') {
				rightIdx--;
			}
			
			if(rightIdx < len/2) return false;
			
			if(arr[i] == arr[rightIdx]) continue;
		}
		
		return result;
    }
}
