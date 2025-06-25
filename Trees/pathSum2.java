Given the root of a binary tree and an integer targetSum, 
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

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
    List<List<Integer>> paths = new ArrayList<>();
    public void getPathSum(TreeNode root, int targetSum, List<Integer> curr){
        if(root == null) return;

        curr.add(root.val);
        targetSum -= root.val;
        
        if(targetSum == 0 && root.left == null && root.right == null){
            paths.add(new ArrayList<>(curr));
        }
        
        getPathSum(root.left, targetSum, curr);
        getPathSum(root.right, targetSum, curr); 

        curr.remove(curr.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        getPathSum(root, targetSum, new ArrayList<>());
        return paths;
    }
}
