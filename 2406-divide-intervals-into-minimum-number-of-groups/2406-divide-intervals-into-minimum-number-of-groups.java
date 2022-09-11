class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int []interval : intervals){
            if(!pq.isEmpty() && pq.peek()<interval[0]) pq.poll();
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}