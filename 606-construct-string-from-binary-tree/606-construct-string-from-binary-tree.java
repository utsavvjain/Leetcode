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
    public String _tree2str(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        sb.append(root.val);
        if(root.left!=null) {
            sb.append("(");
            sb.append(_tree2str(root.left));
            sb.append(")");
        }
        else if(root.right!=null){
            sb.append("(");
            sb.append(")");
            
        }
        if(root.right!=null) {
            sb.append("(");
            sb.append(_tree2str(root.right));
            sb.append(")");
        }
        return sb.toString();
    }
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        return _tree2str(root);
    }
}