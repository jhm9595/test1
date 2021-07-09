package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author minibig
 *
 */
public class LeetCode111 {
	public int minDepth(TreeNode root) {

		return getMinDepth(root, 0);
	}

	private int getMinDepth(TreeNode node, int depth) {
		if (node == null)
			return depth;

		depth++;

		if (node.left == null && node.right == null)
			return depth;

		if (node.left == null)
			return getMinDepth(node.right, depth);

		if (node.right == null)
			return getMinDepth(node.left, depth);

		return Math.min(getMinDepth(node.left, depth), getMinDepth(node.right, depth));
	}
}
