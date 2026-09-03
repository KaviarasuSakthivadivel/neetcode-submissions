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
record TreeNodeDepth(int depth, TreeNode node){};

class Solution {
    public int maxDepth(TreeNode root) {
        Deque<TreeNodeDepth> stack = new ArrayDeque<>();
        stack.push(new TreeNodeDepth(1, root));

        int maxDepth = 0;

        while(!stack.isEmpty()) {
            TreeNodeDepth record = stack.poll();
            TreeNode node = record.node();
            int depth = record.depth();

            if(node != null) {
                maxDepth = Math.max(maxDepth, depth);
                stack.push(new TreeNodeDepth(depth + 1, node.left));
                stack.push(new TreeNodeDepth(depth + 1, node.right));
            }
        }

        return maxDepth;
    }
}
