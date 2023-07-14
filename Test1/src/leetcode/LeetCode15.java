package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/ 
 * @author minibig
 */
public class LeetCode15 {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultAllList = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		
		Set<Integer> zeroSet = new HashSet<Integer>();
		
		int pick = 0;
		int target = 0;
		for(int i = 0; i < nums.length - 2; i++) {
			pick = nums[i];
			target = 0 - pick;  // pick + target = 0
			
			int sum = 0;
			int l = i + 1;
			int r = nums.length - 1;
			while(l < r) {
				sum = nums[l] + nums[r];
				if(sum > target || zeroSet.contains(r)) {
					r--;
				}else if(sum < target) {
					l++;
				}else { // sum == target
					resultAllList.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
					if(nums[i] == nums[l] && nums[l] == nums[r]) {
						zeroSet.add(r);
					}
					l++;
				}
			}
		}
		
		return resultAllList.stream().distinct().collect(Collectors.toList());
    }
}
