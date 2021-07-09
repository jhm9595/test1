package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author minibig
 *
 */
public class LeetCode108 {
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		
		return setNextNode(nums, 0, nums.length - 1, new boolean[nums.length]);
    }
	
	private static TreeNode setNextNode(int[] nums, int begin, int end, boolean[] check) {
		
		int mid = (begin + end) / 2;
		
		check[mid] = true;
		
		return new TreeNode(nums[mid], setNextNode(nums, begin, mid, check), setNextNode(nums, mid + 1, end, check));
	}
}
