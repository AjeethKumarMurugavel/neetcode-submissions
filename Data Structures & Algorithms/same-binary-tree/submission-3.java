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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null || p == null) {
            return p == null && q == null;
        }
        if(q.val != p.val) {
            return false;
        }
        boolean isSameLeft = isSameTree(p.left, q.left);
        boolean isSameRight = isSameTree(p.right, q.right);

        return  isSameLeft && isSameRight;
    }
}
