class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int l=0,r;
        int sum=0;        
        Map<Integer,Integer> map=new HashMap<>();        
        for(r=0;r<nums.length;r++){
            sum+=nums[r];
            if(map.containsKey(nums[r])) {
                int index=map.get(nums[r]);
                while(l<=index) sum-=nums[l++];
            }
            map.put(nums[r],r);
            maxi=Math.max(sum,maxi);
        }
        return maxi;
    }
}