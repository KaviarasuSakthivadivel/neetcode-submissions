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
        if(root == null) {
            return "N";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) {
                sb.append("N,");
            } else {
                sb.append(String.valueOf(node.val)).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("N")) {
            return null;
        }

        String[] decodedArr = data.split(",");
        int index = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(decodedArr[0]));
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(!decodedArr[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(decodedArr[index]));
                queue.add(node.left);
            }
            index++;

            if(!decodedArr[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(decodedArr[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }
}
