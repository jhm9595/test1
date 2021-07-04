package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author minibig
 *
 */
public class LeetCode104 {

	public int maxDepth(TreeNode root) {
		return maxDepth(root, 0);
	}

	public int maxDepth(TreeNode root, int depth) {

		if (root == null) return depth;

		depth++;

		int pDepth = maxDepth(root.left, depth);
		int qDepth = maxDepth(root.right, depth);

		return pDepth > qDepth ? pDepth : qDepth;
	}
}
