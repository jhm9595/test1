package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author minibig
 *
 */
public class LeetCode110 {
	
	private boolean result = true;
	
	public boolean isBalanced(TreeNode root) {
		
		int maxHeight = getMaxHeight(root);
		
		System.out.println("maxHeight : " + maxHeight);
		
		return result;
	}

	private int getMaxHeight(TreeNode root) {
		
		if(root == null) return 0;

		int l = getMaxHeight(root.left);
		int r = getMaxHeight(root.right);
		
		if(Math.abs(l - r) > 1) {
			result = false;
		}
		
		return 1 + Math.max(l, r);
	}
}
