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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean isOdd=false;
        List<TreeNode> lst=new LinkedList<>();
        while(!q.isEmpty()){           
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(isOdd) lst.add(node);
            }
            if(isOdd){
                int i=0,j=lst.size()-1;
                while(i<j){
                    TreeNode a=lst.get(i++);
                    TreeNode b=lst.get(j--);
                    int k=a.val;
                    a.val=b.val;
                    b.val=k;
                }
                lst.clear();
            }
            isOdd=!isOdd;
        }
        return root;
    }
}