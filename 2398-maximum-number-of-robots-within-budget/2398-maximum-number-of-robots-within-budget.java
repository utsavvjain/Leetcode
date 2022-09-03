class Solution {
public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    int ans = 0, j = 0;
    long sum = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < runningCosts.length; i++) {
        sum += runningCosts[i];
        pq.offer(chargeTimes[i]);
        while (!pq.isEmpty() &&  ((sum * pq.size() + pq.peek()) > budget))
        {
            sum -= runningCosts[j];
            pq.remove(chargeTimes[j]);
            j++;
        }
        ans = Math.max(ans, pq.size());
    }
    return ans;
}
}