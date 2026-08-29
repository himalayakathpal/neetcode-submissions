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
    private static int count = 0;
    private static int result = 0;
    public void kthSmallestHelper(TreeNode root) {
        if (root==null) return;
        kthSmallestHelper(root.left);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }

        kthSmallestHelper(root.right);
    }    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestHelper(root);
        return result;

    }
}
