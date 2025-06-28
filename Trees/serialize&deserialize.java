Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
  
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
  You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
        public String serialize(TreeNode root) { 
            if (root == null) return "";

            StringBuilder treeWord = new StringBuilder(); 
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    treeWord.append("n,");
                    continue;
                } else {
                    treeWord.append(curr.val).append(","); 
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }

            return treeWord.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return new TreeNode();
        TreeNode root = new TreeNode(data.charAt(0));
        int i = 1;
        while(i < data.length()){
            root.left = new TreeNode(data.charAt(i));
            i++;
            if(i < data.length()) {
            root.right = new TreeNode(data.charAt(i+1));
            i++;
            }
        }
        return root;
    }
}
 
