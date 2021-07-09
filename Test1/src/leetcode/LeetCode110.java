package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * @author minibig
 *
 */
public class LeetCode110 {

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		return Math.abs(maxHeight(root.left, 0) - maxHeight(root.right, 0)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int maxHeight(TreeNode node, int height) {

		if (node == null)
			return height;
		
		height++;
			
		return Math.max(maxHeight(node.left, height), maxHeight(node.right, height));
	}
}
