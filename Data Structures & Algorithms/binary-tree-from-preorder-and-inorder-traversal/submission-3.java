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
    private HashMap<Integer, Integer> inMap = new HashMap<>();
    private int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if(left > right) {
            return null;
        }

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inMap.get(rootVal);

        root.left = dfs(preorder, left, mid - 1);
        root.right = dfs(preorder, mid + 1, right);

        return root;
    }
}
