package leetcode;

/**
 * https://leetcode.com/problems/remove-element/submissions/
 * @author minibig
 *
 */
public class LeetCode27 {
	public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == val) {
        		right++;
        	}else {
        		nums[left++] = nums[right++];
        	}
        }
        return left;
    }
}
