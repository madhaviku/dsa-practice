Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

  
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
    Stack<Integer> st = new Stack<>();
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.right);
        st.push(root.val);
        inorder(root.left);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        while(!st.isEmpty() && k > 1){
            st.pop();
            k--;
        }
        return st.peek();
    }
}
