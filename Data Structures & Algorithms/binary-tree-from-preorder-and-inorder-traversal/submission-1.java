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

    HashMap<Integer, Integer> nodeVsIndices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            nodeVsIndices.put(inorder[i], i);
        }
        return buildHelper(preorder, inorder, 0, preorder.length, 0, preorder.length);
    }

    public TreeNode buildHelper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart >= preEnd ||  inStart >= inEnd) {
            return null;
        }

        int rootIndx = nodeVsIndices.get(preOrder[preStart]);
        int leftSize = rootIndx - inStart;

        TreeNode root = new TreeNode(preOrder[preStart]);

        root.left = buildHelper(preOrder, inOrder, preStart+1, preStart+leftSize+1, inStart, rootIndx);
        root.right = buildHelper(preOrder, inOrder, preStart+leftSize+1, preEnd, rootIndx+1, inEnd);

        return root;
    }
}
