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
    public int getHeight(TreeNode node){
        if(node==null) return 0;
        return getHeight(node.left)+1;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        if(lh==rh){
            return (int)Math.pow(2,lh)+countNodes(root.right);
        }
        return (int)Math.pow(2,rh)+countNodes(root.left);
    }
}