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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int levelNo = queue.size();
            for(int i = 0 ; i < levelNo ; i++) {
                TreeNode node = queue.poll();
                if(i == 0) {
                    list.add(node.val);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
                
                if(node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        
        return list;
    }
}
