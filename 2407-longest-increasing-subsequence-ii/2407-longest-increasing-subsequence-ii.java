class Solution {
    int segmentTree[];
    public int query(int l,int r,int idx,int low,int high){
        if(low>r || high<l) return 0;
        if(low>=l && high<=r) return segmentTree[idx]; //lies
        int mid=low+(high-low)/2;
        return Math.max(query(l,r,2*idx+1,low,mid),query(l,r,2*idx+2,mid+1,high));
    }
    public void update(int idx,int val,int x,int low,int high){
        if(low==high){
          segmentTree[x]=val;
            return;
        } 
        int mid=low+(high-low)/2;
        if(idx<=mid)
            update(idx,val,2*x+1,low,mid);
        else 
            update(idx,val,2*x+2,mid+1,high);
        segmentTree[x]=Math.max(segmentTree[2*x+1],segmentTree[2*x+2]);
        
    }
    public int lengthOfLIS(int[] nums, int k) {
        int n = 1;
        while(n <= 200000) n *= 2;
        segmentTree=new int[2*n];
        int ans=1;
        for(int i=0;i<nums.length;i++){
            int left=Math.max(1,nums[i]-k);
            int right=nums[i]-1;           
            int q=query(left,right,0,0,n-1);
            ans=Math.max(q+1,ans);
            update(nums[i],q+1,0,0,n-1);
        }
        return ans;
    }
}