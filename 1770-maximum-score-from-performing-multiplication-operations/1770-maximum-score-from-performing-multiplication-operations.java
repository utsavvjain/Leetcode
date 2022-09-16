class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[]=new int[multipliers.length+1];
        int n=nums.length;        
        for(int mIndex=multipliers.length-1;mIndex>=0;mIndex--){
            int []nw=dp.clone();
            for(int lIndex=mIndex;lIndex>=0;lIndex--){ //left at max can be mIndex
                int left=multipliers[mIndex]*nums[lIndex] + nw[lIndex+1];
                int right=multipliers[mIndex]*nums[n-1-(mIndex-lIndex)] + nw[lIndex];
                dp[lIndex]=Math.max(left,right);
            }
        }
        return dp[0];
    
    }
}