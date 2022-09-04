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
    class Node{
        TreeNode node;
        int x;
        int y;
        Node(TreeNode n,int a,int b){
            node=n;
            x=a;
            y=b;
        }
        public String toString(){
            return String.format("(%d, %d, %d)",node.val,x,y);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<>(); 
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null) return ans;
        q.offer(new Node(root,0,0));
        while(!q.isEmpty()){
            Node node=q.poll();
            TreeMap<Integer,PriorityQueue<Integer>> mp=map.getOrDefault(node.y,new TreeMap<>());
            PriorityQueue<Integer> pq=mp.getOrDefault(node.x,new PriorityQueue<>((a,b)->a-b));
            pq.offer(node.node.val);
            mp.put(node.x,pq);
            map.put(node.y,mp);
            if(node.node.left!=null) q.offer(new Node(node.node.left,node.x+1,node.y-1));
            if(node.node.right!=null) q.offer(new Node(node.node.right,node.x+1,node.y+1));
        }
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry : map.entrySet()){
            List<Integer> lst=new LinkedList<>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> ent : entry.getValue().entrySet()) {
                PriorityQueue<Integer> val=ent.getValue();
                while(!val.isEmpty()) lst.add(val.poll());
            }
            ans.add(lst);
        }
        return ans;
    }
}