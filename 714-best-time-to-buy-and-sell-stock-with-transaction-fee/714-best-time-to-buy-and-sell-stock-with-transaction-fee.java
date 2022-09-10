class Solution {
    public int maxProfit(int[] prices, int fee,int i,boolean buy,int [][]dp) {
        if(i==prices.length) return 0;
        int profit;
        if(dp[i][buy?0:1]!=-1) return dp[i][buy?0:1];
        if(buy){
            profit=Math.max(maxProfit(prices,fee,i+1,true,dp),maxProfit(prices,fee,i+1,false,dp)-prices[i]);
        }else{
            profit=Math.max(maxProfit(prices,fee,i+1,false,dp),maxProfit(prices,fee,i+1,true,dp)+prices[i]-fee);            
        }
        return dp[i][buy?0:1]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return maxProfit(prices,fee,0,true,dp);
    }
}