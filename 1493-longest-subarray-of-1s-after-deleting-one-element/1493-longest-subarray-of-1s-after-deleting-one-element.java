class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int ans=0;
        int cnt=0;
        for(;i<nums.length;i++){
            if(nums[i]==0) cnt++;
            if(cnt==2){
                while(nums[j++]!=0);
                cnt-=1;
            }
            ans=Math.max(ans,i-j);
        }
        return ans;
    }
}