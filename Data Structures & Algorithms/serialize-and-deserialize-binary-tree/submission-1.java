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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        //System.out.println("result - " + String.join(",", list));
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return construct(nodes);
    }

    int index = 0;
    public TreeNode construct(String[] data) {
        //System.out.println("Calling - "+index);
        if(index >= data.length || data[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;
        root.left = construct(data);
        root.right = construct(data);
        return root;
    }

    public void dfs(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("N");
            return;
        }
        list.add(root.val+"");
        dfs(root.left, list);
        dfs(root.right, list);

    }
}
