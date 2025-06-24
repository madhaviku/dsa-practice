Given the root of a binary tree, return the inorder traversal of its nodes' values.

Recursive Tree Traversal:
class Solution {
    public List<Integer> order = new ArrayList<>();
    public void raversal(TreeNode root){
        if(root != null){
        if(root.left != null) raversal(root.left);
        order.add(root.val);
        if(root.right != null) raversal(root.right);
       }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        raversal(root);
        return order;
    }
}

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
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    curr = curr.left;
                }else{
                    temp.right = null;
                    nodes.add(curr.val);
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
