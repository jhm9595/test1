package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
public class LeetCode26 {
	
	public int removeDuplicates(int[] nums) {   
	       
        Set<Integer> set = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }else{
                set.add(nums[i]);
                nums[count++] = nums[i];
            }
        }
        
        return set.size();
    }
}
