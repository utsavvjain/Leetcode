class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length+1][2][k+1];        
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int l=1;l<=k;l++){
                    if(j==0)            
                        dp[i][j][l]=Math.max(dp[i+1][1][l]-prices[i], dp[i+1][0][l]);
                    else 
                        dp[i][j][l]=Math.max(dp[i+1][0][l-1]+prices[i], dp[i+1][1][l]);                 
                }
            }
        }
        return dp[0][0][k];
    }
}