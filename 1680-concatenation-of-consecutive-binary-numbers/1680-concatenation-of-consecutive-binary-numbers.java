class Solution {
    public int concatenatedBinary(int n) {
        long MOD=(long)1e9+7;
        long ans=0;
        int len=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0) len+=1;
            ans=((ans<<len) + i)%MOD;
        }
        return (int)ans;
    }
}