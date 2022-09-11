class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int []graph=new int[1000002];
        for(int []interval : intervals){
            graph[interval[0]]++;
            graph[interval[1]+1]--;
        }
        int mini=graph[0];
        for(int i=1;i<graph.length;i++){
            graph[i]+=graph[i-1];
            mini=Math.max(mini,graph[i]);
        }
        return mini;
    }
}