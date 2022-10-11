class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int prevTime=0;
        int max=Integer.MIN_VALUE;
        int id=Integer.MAX_VALUE;
        for(int []log : logs){
            int time=log[1]-prevTime;
            if(time>=max){
                if(time==max) id=Math.min(id,log[0]);
                else id=log[0];
                max=time;
            }
            prevTime=log[1];
        }
        return id;
        
    }
}