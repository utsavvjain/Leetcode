class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0,j=0,ans=0,prod=1;
        if(k==0) return 0;
        for(;i<nums.length;i++){
            prod*=nums[i];
            while(prod>=k && j<nums.length) prod=prod/nums[j++];
            ans+=(i-j+1);
        }
        return ans>0?ans:0;
    }
}