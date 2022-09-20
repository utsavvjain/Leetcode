class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left=1,right=m*n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(feas(mid,k,m,n)) {
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean feas(int mid,int k,int m,int n) {
        int cnt=0;
        for(int i=1;i<=m;i++) cnt+=Math.min(mid/i,n);
        return cnt>=k;
    }
}