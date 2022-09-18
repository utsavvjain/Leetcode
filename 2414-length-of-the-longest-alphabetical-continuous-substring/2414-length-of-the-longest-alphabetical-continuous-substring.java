class Solution {
    public int longestContinuousSubstring(String s) {
        int ans=1;
        int length=1;
        for(int i=1;i<s.length();i++){
            if((s.charAt(i-1)+1)!=s.charAt(i)){
                length=1;
                continue;
            }
            length+=1;
            ans=Math.max(ans,length);
        }
        return ans;
    }
}