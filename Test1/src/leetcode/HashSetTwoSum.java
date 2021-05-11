package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum/submissions/
 */

public class HashSetTwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(list.contains(target-nums[i])) {
				return new int[] {i, list.indexOf(target-nums[i])};
			}else {
				list.add(nums[i]);
			}
		}
		return null;
    }
}
