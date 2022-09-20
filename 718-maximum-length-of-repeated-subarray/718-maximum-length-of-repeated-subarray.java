class Solution {    
    int sln=0;
    public int lcs(int[] nums1, int[] nums2,int i,int j,int[][] dp) {
        if(i==nums1.length || j==nums2.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(nums1[i]==nums2[j]){
            ans=1+lcs(nums1,nums2,i+1,j+1,dp);
            sln=Math.max(sln,ans);            
        }
        lcs(nums1,nums2,i+1,j,dp);
        lcs(nums1,nums2,i,j+1,dp);
        return dp[i][j]=ans;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++) dp[i][j]=-1;
        }
        lcs(nums1,nums2,0,0,dp);
        return sln;
    }
}