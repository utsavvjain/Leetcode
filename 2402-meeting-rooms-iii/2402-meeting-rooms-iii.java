class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->{
        if(a[0]==b[0]) return a[1]-b[1];
        return a[0]-b[0];
        });
        
        PriorityQueue<Integer> available=new PriorityQueue<>();
        for(int i=0;i<n;i++) available.offer(i);
        int ans[]=new int[n];
        int idx;
        for(int []meet : meetings){
            int s=meet[0], e=meet[1];
            
            while(!pq.isEmpty() && pq.peek()[0]<=s) available.offer(pq.poll()[1]); //this is going to remove all the meetings that have ended
            
            if(available.size()>0){
                idx=available.poll();
                pq.offer(new int[]{e,idx});
                ans[idx]+=1;            
            }
            
            else{
                int []top=pq.poll();
                idx=top[1];                
                pq.offer(new int[]{e+top[0]-s,idx});
                ans[idx]+=1;            
            }            
        }
        
        int roomNo=0,max=ans[0];
        for(int i=1;i<ans.length;i++){
            System.out.println(ans[i]);
            if(ans[i]>max){
                max=ans[i];
                roomNo=i;
            }
        }
        return roomNo;
    }
}