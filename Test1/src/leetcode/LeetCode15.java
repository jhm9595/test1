package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/ 
 * @author minibig
 */
public class LeetCode15 {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultAllList = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		
		int pick = 0;
		int target = 0;
        int rIdx = nums.length - 1;
		for(int i = 0; i < nums.length - 2; i++) {
			pick = nums[i];
			target = 0 - pick;  // pick + target = 0
			
			int sum = 0;
			int l = i + 1;
			int r = rIdx;
			while(l < r) {
				sum = nums[l] + nums[r];
				if(sum > target) {
					r--;
				}else if(sum < target) {
					l++;
				}else { // sum == target
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					resultAllList.add(list);
					if(nums[i] == nums[l] && nums[l] == nums[r]) {
						rIdx--;
					}
					l++;
				}
			}
		}
		
		return resultAllList.stream().distinct().collect(Collectors.toList());
    }
}
