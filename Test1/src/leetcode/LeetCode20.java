package leetcode;

/*
 * https://leetcode.com/problems/valid-parentheses/
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        
    	String s_tmp = s;

        if(s_tmp.length() % 2 != 0){
            return false;
        }
        if(s_tmp.length() == 0){
            return true;
        }
        
    	s_tmp = s.replace("()", "").replace("{}", "").replace("[]", "");
        
        if(s.length() == s_tmp.length()) {
        	return false;
        }
        
        return isValid(s_tmp);
    }
}
