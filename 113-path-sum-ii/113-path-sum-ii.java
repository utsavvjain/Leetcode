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
    public void dfs(TreeNode root,List<List<Integer>> ans,List<Integer> lst,int target){
        if(root==null) return;
        lst.add(root.val);
        if(root.left==null && root.right==null){
            if(target-root.val==0) ans.add(lst);
            return;
        }
        dfs(root.left,ans,new LinkedList<>(lst),target-root.val);
        dfs(root.right,ans,new LinkedList<>(lst),target-root.val);

        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {        
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null) return ans;
        List<Integer> lst=new LinkedList();
        dfs(root,ans,lst,targetSum);
        return ans;
    }
}