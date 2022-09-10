class Solution {
    public int maxProfit(int i, int k,boolean buy,int []prices,int [][][]memo) {
        if(k==0 || i==prices.length) return 0;        
        if(buy && i==prices.length-1) return 0;
        if(memo[i][(buy)?0:1][k]!=-1) return memo[i][(buy)?0:1][k];
        int ans;
        if(buy){            
            ans=Math.max(maxProfit(i+1,k,false,prices,memo)-prices[i], maxProfit(i+1,k,true,prices,memo));
        }  
        else {
            ans=Math.max(maxProfit(i+1,k-1,true,prices,memo)+prices[i], maxProfit(i+1,k,false,prices,memo));
        }
        return memo[i][(buy)?0:1][k]=ans;
    }
    public int maxProfit(int k, int[] prices) {
        int ans=Integer.MIN_VALUE;
        int memo[][][]=new int[prices.length+1][2][k+1];        
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[i].length;j++){
                for(int l=0;l<memo[i][j].length;l++){
                    memo[i][j][l]=-1;
                }

            }
        }
        return maxProfit(0,k,true,prices,memo);
    }
}