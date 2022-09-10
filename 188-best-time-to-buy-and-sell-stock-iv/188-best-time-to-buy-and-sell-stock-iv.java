class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][]=new int[2][k+1];    
        
        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int l=1;l<=k;l++){
                    if(j==0)            
                        dp[j][l]=Math.max(dp[1][l]-prices[i], dp[0][l]);
                    else 
                        dp[j][l]=Math.max(dp[0][l-1]+prices[i], dp[1][l]);                 
                }
            }
        }
        return dp[0][k];
    }
}