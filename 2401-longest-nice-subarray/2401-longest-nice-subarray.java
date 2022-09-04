class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i=0,j=0;
        int maxi=1;
        int AND=nums[0];
        for(j=1;j<nums.length;j++){
            while((AND&nums[j])!=0) AND=AND^nums[i++];
            AND=AND | nums[j];
            maxi=Math.max(maxi,j-i+1);
        }                        
        return maxi;
    }
}