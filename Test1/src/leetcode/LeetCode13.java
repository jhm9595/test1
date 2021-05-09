package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/roman-to-integer/submissions/
 */
public class LeetCode13 {

	class Solution {
	    public int romanToInt(String s) {
	        Map<String, Integer> roman = new HashMap<String, Integer>();
	        roman.put("I", 1);
	        roman.put("V", 5);
	        roman.put("X", 10);
	        roman.put("L", 50);
	        roman.put("C", 100);
	        roman.put("D", 500);
	        roman.put("M", 1000);
	        
	        String ch;
	        int val;
	        int bfVal = 0;
	        
	        int sum = 0;
	        for(int i = s.length()-1; i >= 0; i--){
	            ch = s.substring(i, i+1);
	            val = roman.get(ch);
	            
	            if(bfVal > val){
	                sum = sum - val;
	            }else{
	                sum = sum + val;
	            }
	            
	            bfVal = val;
	        }
	        
	        return sum;
	    }
	}
}
