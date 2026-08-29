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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> levelResult = new ArrayList<>();
            while (n>0) {
                TreeNode temp = q.poll();
                levelResult.add(temp.val);
                if (temp.left!=null) q.offer(temp.left);
                if (temp.right!=null) q.offer(temp.right);
                n--;
            }
            result.add(levelResult);
        }
        return result;
    }
}
