package leetcode;

import java.util.ArrayList;
import java.util.List;

import commonclass.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author minibig
 *
 */
public class LeetCode94 {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        
		List<Integer> result =  new ArrayList<Integer>();
		recursive(result, root);
		return result;
	}

	private void recursive(List<Integer> result, TreeNode root) {
		if(root != null) {
			recursive(result, root.left);
			result.add(root.val);
			recursive(result, root.right);
		}
	}
}
