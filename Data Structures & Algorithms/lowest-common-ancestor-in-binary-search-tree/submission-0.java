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
    public void getRootToNodePath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null || node == null) return;
        if (root == node) {
            path.add(root);
            return;
        }
        getRootToNodePath(root.left, node, path);
        if (!path.isEmpty())
        {
             path.add(root);
             return;
        }
        getRootToNodePath(root.right, node, path);
        if (!path.isEmpty())
        {
             path.add(root);
             return;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        getRootToNodePath(root, p, pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        getRootToNodePath(root, q, pathQ);

        int i = pathP.size()-1;
        int j = pathQ.size()-1;
        System.out.println(pathQ.size());
        while (i>=0 && j>=0 && pathP.get(i) == pathQ.get(j)) {
            i--;
            j--;
        }
        return pathP.get(i+1);
    }
}
