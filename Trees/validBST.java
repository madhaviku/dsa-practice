Validate Binary Search Tree
 
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
    public boolean valid(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        return valid(root, null, null);

    }
}
