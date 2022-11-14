class Solution {
    //CAN BE SOLVED USING DFS / UNION FIND
    public int removeStones(int[][] stones) {
        Set<int[]> visited=new HashSet<>();
        int ans=0;
        for(int []stone : stones){
            if(!visited.contains(stone)){
                dfs(stone,stones,visited);
                ans+=1;
            }
        }
        return stones.length-ans;
    }
    public void dfs(int []stone,int [][]stones,Set<int []>visited){
        visited.add(stone);
        for(int []stone1 : stones){
            if(!visited.contains(stone1)){
                if(stone[0]==stone1[0] || stone[1]==stone1[1]) dfs(stone1,stones,visited);
            }
        }
    }
}