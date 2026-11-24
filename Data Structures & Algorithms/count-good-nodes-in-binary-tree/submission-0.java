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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        countGood(root, root.val);
        return count+1;
    }

    public void countGood(TreeNode root, int max) {
        if(root == null) {
            return;
        }
        max = Math.max(max, root.val);
        if(root.left != null && root.left.val >= max) {
            count++;
        }
        if(root.right != null && root.right.val >= max) {
            count++;
        }
        countGood(root.left, max);
        countGood(root.right, max);
    }
}
