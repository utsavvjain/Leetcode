class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int max=-1,min=-1;
        int start=0;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK){
                min=max=-1;
                start=i+1;
            }
            if(nums[i]==minK) min=i;
            if(nums[i]==maxK) max=i;
            if(min!=-1 && max!=-1) ans+=(Math.min(max,min)-start+1);
        }
        return ans;
    }
}