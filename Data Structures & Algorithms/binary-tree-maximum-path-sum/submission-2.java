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
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculate(root);
        return sum;
    }

    public int calculate(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(calculate(root.left), 0);
        int rightSum = Math.max(calculate(root.right), 0);
        sum = Math.max(sum, root.val+leftSum+rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
