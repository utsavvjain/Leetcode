class Solution {    
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n<m) return findLength(nums2,nums1);
        int dp[]=new int[n+1];
        int ans=0;
        for(int i=nums1.length-1;i>=0;i--){
            int prev[]=new int[n+1];
            for(int j=nums2.length-1;j>=0;j--){
                if(nums1[i]==nums2[j]){
                    prev[j]=1+dp[j+1];
                    ans=Math.max(ans,prev[j]);
                }                
            }
            dp=prev;
        }
        return ans;
    }
}