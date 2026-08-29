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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("n ");
                continue;
            }
            sb.append(temp.val + " ");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] vals = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int curr = 1;
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if (vals[curr].equals("n")) parent.left = null;
            else {
                TreeNode left = new TreeNode(Integer.parseInt(vals[curr]));
                parent.left = left;
                q.offer(left);
            }
            if (vals[++curr].equals("n")) parent.right = null;
            else {
                TreeNode right = new TreeNode(Integer.parseInt(vals[curr]));
                parent.right = right;
                q.offer(right);
            }
            curr++;
        }
        return root;
    }
}
