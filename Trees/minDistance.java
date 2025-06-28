Minimum Distance Between BST Nodes

Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

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
    public void inorder(TreeNode root, ArrayList<Integer> al){
        if(root == null) return;
        inorder(root.left, al);
        al.add(root.val);
        inorder(root.right, al);
    }
    public int minDiffInBST(TreeNode root) {
         ArrayList<Integer> al = new ArrayList<>();
         inorder(root, al);
         Collections.sort(al);
         int diff = Integer.MAX_VALUE;
         for(int i = 1; i < al.size(); i++){
            diff = Math.min(diff, al.get(i) - al.get(i-1));
         }
         return diff;
    }
}
