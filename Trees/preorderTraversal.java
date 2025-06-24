Binary Tree Preorder Traversal
============================================================
Recursive approach:
class Solution {
     public List<Integer> order = new ArrayList<>();
    public void raversal(TreeNode root){
        if(root != null){
        order.add(root.val);
        if(root.left != null) raversal(root.left);        
        if(root.right != null) raversal(root.right);
       }
    } 
    public List<Integer> preorderTraversal(TreeNode root) {
        raversal(root);       
        return order;
    }
}
=============================================================
Morris Tree Traversal Algorithm  
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;
         TreeNode curr = root;
         while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = curr;
                    nodes.add(curr.val);
                    curr = curr.left;
                }else{
                    temp.right = null;                    
                    curr = curr.right;
                }
            }else{
                nodes.add(curr.val);
                curr = curr.right;
            }
         }
         return nodes;
    }
}
