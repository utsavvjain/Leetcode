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
    
    public int dfs(TreeNode root,int freq[]) {
        if(root==null) return 0;
        freq[root.val]+=1;
        if(root.left==null && root.right==null){
            int cnt=0;
            for(int i=1;i<freq.length;i++) {
                if(freq[i]!=0 && freq[i]%2!=0) cnt+=1;
            }
            freq[root.val]-=1;
            return (cnt>1)?0:1;
        }
        int ans=dfs(root.left,freq)+dfs(root.right,freq);
        freq[root.val]-=1;
        return ans;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int freq[]=new int[10];
        return dfs(root,freq);
    }
}