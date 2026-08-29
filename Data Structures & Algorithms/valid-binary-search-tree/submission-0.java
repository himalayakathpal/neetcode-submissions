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
    public boolean isValidBSTHelper(TreeNode root, int mini, int maxi) {
        if (root == null) return true;
        if (root.val <= mini || root.val>=maxi){
            return false;
        }
        return isValidBSTHelper(root.left, mini, root.val) &&
        isValidBSTHelper(root.right,root.val,maxi);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
