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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> (b-a));

        iterate(root, k, queue);
        return queue.peek();
        
    }

    public void iterate(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if(root == null) {
            return;
        }

        iterate(root.left, k, queue);
        queue.offer(root.val);
        if(queue.size() > k) {
            queue.poll();
        }
        iterate(root.right, k, queue);

    }
}
