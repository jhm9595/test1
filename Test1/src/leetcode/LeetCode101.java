package leetcode;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * @author minibig
 *
 */
public class LeetCode101 {
	
	public boolean isSymmetric(TreeNode root) {

		return checkSymmetric(root.left, root.right);
	}

	private boolean checkSymmetric(TreeNode p, TreeNode q) {

		if (p == null && q == null) return true;

		if (p == null ^ q == null) return false;

		if (p.val != q.val) return false;

		return checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
	}
}
