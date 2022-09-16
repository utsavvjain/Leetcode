class Solution {
    public int maximumScore(int[] nums, int[] multipliers,int lIndex,int mIndex,int dp[][]) {
        int n=nums.length;
        if(mIndex==multipliers.length) return 0;
        if(lIndex>mIndex) return 0;
        if(dp[lIndex][mIndex]!=Integer.MIN_VALUE) return dp[lIndex][mIndex];
        int left=multipliers[mIndex]*nums[lIndex] + maximumScore(nums,multipliers,lIndex+1,mIndex+1,dp);
        int right=multipliers[mIndex]*nums[n-1-(mIndex-lIndex)] + maximumScore(nums,multipliers,lIndex,mIndex+1,dp); //to calculate right index
        return dp[lIndex][mIndex]=Math.max(left,right);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][]=new int[multipliers.length][multipliers.length];
        for(int i=0;i<dp.length;i++) for(int j=0;j<dp[i].length;j++) dp[i][j]=Integer.MIN_VALUE;
        return maximumScore(nums,multipliers,0,0,dp);
    }
}