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
    public int height(TreeNode root, boolean[] isB) {
        if (root == null)  return 0;
        int leftHeight = height(root.left, isB );
        int rightHeight = height(root.right, isB );
        if (Math.abs(leftHeight-rightHeight) >1) {
            isB[0] = false;
        }
        return Math.max(leftHeight,rightHeight) +1;

    }
    public boolean isBalanced(TreeNode root) {
        boolean[] isB = new boolean[1];
        isB[0] = true;
        height(root, isB);
        return isB[0];    
    }
}
