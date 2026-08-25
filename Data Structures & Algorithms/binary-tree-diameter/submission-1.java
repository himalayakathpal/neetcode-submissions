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
    public static int dia = 0;
    
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = root.left!=null ? diameterOfBinaryTreeHelper(root.left) +1 : 0;
        int rightHeight = root.right!=null ? diameterOfBinaryTreeHelper(root.right) +1 : 0;
        dia = Math.max(dia, leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        diameterOfBinaryTreeHelper(root);
        return dia;
    }
}
