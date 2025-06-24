Binary Tree Level Order Traversal

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if(root == null) return nodes;
        Queue<TreeNode> q = new ArrayDeque();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                list.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);                
            }
            nodes.add(list);
        }
        return nodes;
    }
}
