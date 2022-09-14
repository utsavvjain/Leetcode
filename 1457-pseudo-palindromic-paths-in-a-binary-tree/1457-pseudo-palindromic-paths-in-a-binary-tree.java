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
    int count=0;
    public void dfs(TreeNode root,int freq) {
        if(root!=null){
            freq=freq^(1<<root.val);
            if(root.left==null && root.right==null){
                if((freq&(freq-1))==0) count+=1;
            }
            dfs(root.left,freq);
            dfs(root.right,freq);            
        }        
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,0);
        return count;
    }
}