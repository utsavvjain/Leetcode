class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(visited[i],-1);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,0,k});
        int []qNode;
        int x,y;
        while(!q.isEmpty()){
            qNode=q.poll();
            x=qNode[0];
            y=qNode[1];
            if(x>=n || x<0 || y>=m || y<0) continue;
            if(x==n-1 && y==m-1) return qNode[2];
            if(grid[x][y]==1){
                if(qNode[3]>0) qNode[3]--;
                else continue;
            }
            if(visited[x][y]!=-1 && visited[x][y]>=qNode[3]) continue;
            visited[x][y]=qNode[3];
            q.offer(new int[]{x+1,y,qNode[2]+1,qNode[3]});
            q.offer(new int[]{x,y+1,qNode[2]+1,qNode[3]});
            q.offer(new int[]{x-1,y,qNode[2]+1,qNode[3]});
            q.offer(new int[]{x,y-1,qNode[2]+1,qNode[3]});
            
        }
        return -1;
    }
}