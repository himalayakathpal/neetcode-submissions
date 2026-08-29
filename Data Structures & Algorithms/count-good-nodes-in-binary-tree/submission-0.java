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
    public int goodNodesHelper(TreeNode root, int maxi) {
       if (root == null) return 0;
       int count = 0;
       if (root.val>=maxi) {
            maxi = root.val;
            count++;
       }
       count+= goodNodesHelper(root.left, maxi);
       count+= goodNodesHelper(root.right, maxi);       
        return count;
    }

    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, Integer.MIN_VALUE);
    }
}
