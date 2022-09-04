class Solution {
    private int _numberOfWays(int startPos, int endPos, int k,int dp[][]) {
        if(k==0){
            if(startPos==endPos) return 1;
            return 0;
        }
       if(Math.abs(startPos-endPos)>k) return 0;
        if(dp[startPos+1000][k]!=-1) return dp[startPos+1000][k];
        int plusOne=0,minusOne=0;
        plusOne=_numberOfWays(startPos+1,endPos,k-1,dp);
        minusOne=_numberOfWays(startPos-1,endPos,k-1,dp);
        return dp[startPos+1000][k]=(plusOne+minusOne)%1000000007;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int dp[][]=new int[3000][k+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                    dp[i][j]=-1;
            }
        }
        return _numberOfWays(startPos,endPos,k,dp);
    }
}