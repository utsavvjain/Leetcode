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
    public int countGoodNodes(TreeNode root,int max){
        if(root==null) return 0;
        int ans=(max>root.val)?0:1;
        int left=countGoodNodes(root.left,Math.max(root.val,max));
        int right=countGoodNodes(root.right,Math.max(root.val,max));
        return ans+left+right;
        
    }
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root,Integer.MIN_VALUE);
    }
}