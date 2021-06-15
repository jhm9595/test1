package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * 
 * @author minibig
 *
 */
public class LeetCode53 {

	public int maxSubArray(int[] nums) {
		
		int ans = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] > 0) {
				nums[i] = nums[i-1] + nums[i];
			}
			ans = max(ans, nums[i]);
		}
		
		return ans;

	}
	
	public int minSubArray(int[] nums) {
		
		int ans = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] < 0) {
				nums[i] = nums[i-1] + nums[i];
			}
			ans = min(ans, nums[i]);
		}
		return ans;

	}

	private int max(int ans, int i) {
		return ans > i ? ans : i;
	}
	
	private int min(int ans, int i) {
		return ans < i ? ans : i;
	}
}