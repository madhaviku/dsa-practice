Post order Tree Traversal

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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return nodes;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        nodes.add(root.val);
        return nodes;
    }
}
