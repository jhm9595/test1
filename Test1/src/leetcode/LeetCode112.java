package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 * @author minibig
 *
 */
public class LeetCode112 {

	public boolean hasPathSum(TreeNode root, int targetSum) {

		if (root == null)
			return false;

		return checkSum(root, 0, targetSum);
	}

	private boolean checkSum(TreeNode node, int sum, int targetSum) {

		if (node == null)
			return sum == targetSum;

		sum = sum + node.val;

		if (node.left == null && node.right == null)
			return sum == targetSum;

		if (node.left == null)
			return checkSum(node.right, sum, targetSum);

		if (node.right == null)
			return checkSum(node.left, sum, targetSum);

		return checkSum(node.left, sum, targetSum) || checkSum(node.right, sum, targetSum);
	}
}
