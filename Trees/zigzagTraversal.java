Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
  (i.e., from left to right, then right to left for the next level and alternate between).

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if(root == null) return nodes;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ll = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                ll.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(reverse){
                Collections.reverse(ll);
            }
            reverse = !reverse;
            nodes.add(ll);
        }
        return nodes;
    }
}
