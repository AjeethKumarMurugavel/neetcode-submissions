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

class Solution {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root, 0);
        return isBalanced;
    }

    public int helper(TreeNode root, int level) {
        if(root == null) {
            return level;
        }
        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);

        if(Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(right, left);
    }
}
