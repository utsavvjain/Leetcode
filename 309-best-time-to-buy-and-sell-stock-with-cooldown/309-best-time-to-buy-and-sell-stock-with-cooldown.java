class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[2][prices.length+2];
        for(int index=prices.length-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    dp[buy][index]=Math.max(dp[1][index+1],dp[0][index+1]-prices[index]);
                }
                else{
                    dp[buy][index]=Math.max(dp[0][index+1],dp[1][index+2]+prices[index]);       
                }
            }
        }
        return dp[1][0];
    }
}