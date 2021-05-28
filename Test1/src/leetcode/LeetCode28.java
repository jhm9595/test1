package leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/submissions/
 * @author minibig
 *
 */
public class LeetCode28 {

	public int strStr(String haystack, String needle) {
        
        if(!haystack.contains(needle)){
            return -1;
        }else{
        	int len = needle.length();
        	for(int i = 0; i <= haystack.length() - len; i++) {
        		if(haystack.substring(i, i + len).equals(needle)) {
        			return i;
        		}
        	}
            return 0;
        }
    }
}
