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
            return haystack.indexOf(needle);
        }
    }
}
