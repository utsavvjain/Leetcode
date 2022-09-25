class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int inc[]=new int[n];        
        int dec[]=new int[n];
        inc[0]=1;
        for(int i=1;i<n;i++){            
            if(nums[i-1]>=nums[i]) inc[i]=inc[i-1]+1;
            else inc[i]=1;
        }
        dec[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]>=nums[i]) dec[i]=dec[i+1]+1;
            else dec[i]=1;
        }        
        List<Integer> list=new LinkedList<>();
        for(int i=k;i<n-k;i++){
            if(inc[i-1]>=k && dec[i+1]>=k) list.add(i);
        }
        return list;
    }
}