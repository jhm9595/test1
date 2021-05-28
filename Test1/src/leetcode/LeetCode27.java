package leetcode;

/**
 * https://leetcode.com/problems/remove-element/submissions/
 * @author minibig
 *
 */
public class LeetCode27 {
	public static int removeElement(int[] nums, int val) {
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == val) {
        		continue;
        	}else {
        		nums[left++] = nums[i];
        	}
        }
        return left;
    }
}
