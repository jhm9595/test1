package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/submissions/
 */

public class HashMapTwoSum {

	public static int[] twoSum(int[] nums, int target) {
        
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]).intValue(), i};
			}else {
				map.put(nums[i], i);
			}
		}
		return null;
	}
}
