package leetcode;

/*
 * https://leetcode.com/problems/longest-common-prefix/submissions/
 */
public class LeetCode14 {
	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        
	        return divide(strs)[0];
	    }
	    
	    public String[] divide(String[] strs){
	        
	        if(strs.length == 1){
	            return strs;
	        }
	        
	        int mid = strs.length / 2;
	        
	        String[] l = new String[mid];
	        String[] r = new String[strs.length - mid];
	        
	        for(int i = 0 ; i < strs.length; i++){
	            if(i < mid){
	                l[i] = strs[i];
	            }else{
	                r[i-mid] = strs[i];
	            }
	        }
	        
	        String[] left = divide(l);
	        String[] right = divide(r);
	        
	        return conquer(left, right);
	    }
	    
	    public String[] conquer(String[] left, String[] right){
	        
	        String min = "";
	        String lStr = left[0];
	        String rStr = right[0];
	        if(lStr.length() > rStr.length()){
	            min = rStr;
	            for(int i = 0; i < rStr.length(); i++){
	                if(!lStr.startsWith(min)){
	                    min = min.substring(0, min.length()-1);
	                }else{
	                    return new String[]{min};
	                }
	            }
	        }else{
	            min = lStr;
	            for(int i = 0; i < lStr.length(); i++){
	                if(!rStr.startsWith(min)){
	                    min = min.substring(0, min.length()-1);
	                }else{
	                    return new String[]{min};
	                }
	            }
	        }
	        
	        return new String[]{""};
	    }
	}
}
