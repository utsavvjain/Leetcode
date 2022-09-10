class Solution {
    public int maxProfit(int[] prices,int index,boolean buy,int dp[][]) {
        if(index>=prices.length) return 0;
        if(dp[index][(buy)?0:1]!=-1) return dp[index][(buy)?0:1];
        int profit=0;
        if(buy){
            profit=Math.max(maxProfit(prices,index+1,true,dp),maxProfit(prices,index+1,false,dp)-prices[index]);
        }
        else{
            profit=Math.max(maxProfit(prices,index+1,false,dp),maxProfit(prices,index+2,true,dp)+prices[index]);            
        }
        return dp[index][(buy)?0:1]=profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return maxProfit(prices,0,true,dp);
    }
}