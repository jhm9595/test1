package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 * @author minibig
 */
public class LeetCode16 {

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int threeSum = 0;
		int minAbs = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {

			int l = i + 1;
			int r = nums.length - 1;

			if (i == 0) {
				threeSum = nums[i] + nums[l] + nums[r];
			}

			while (l < r) {

				int sum = nums[i] + nums[l] + nums[r];

				if (sum == target) {
					return sum;
				} else if (target < sum) {
					r--;
				} else {
					l++;
				}
				if (minAbs > Math.abs(target - sum)) {
					minAbs = Math.abs(target - sum);
					threeSum = sum;
				}
			}
		}

		return threeSum;
	}
}
