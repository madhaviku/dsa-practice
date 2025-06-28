All Nodes Distance K in Binary Tree
  
Given the root of a binary tree, the value of a target node target, and an integer k, 
  return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    private void parentMapping(TreeNode curr, TreeNode root){
        if(curr == null) return;
        parent.put(curr, root);
        parentMapping(curr.left, curr);
        parentMapping(curr.right, curr);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        parentMapping(root, null);

        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        q.offer(target); seen.add(target);
        int dist = 0;
        while(!q.isEmpty()){
            if(dist == k) break;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                for(TreeNode nei : Arrays.asList(curr.left, curr.right, parent.get(curr))){
                    if(nei != null && !seen.contains(nei)){
                        seen.add(nei);
                        q.offer(nei);
                    } 
                }
            }
            dist++;
        }

        while(!q.isEmpty()){
            nodes.add(q.poll().val);
        }
        return nodes;
    }
}
