class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost[]=new int[s.length()];
        for(int i=0;i<s.length();i++) {
            cost[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        for(int i=0;i<cost.length;i++) System.out.print(cost[i]+" ");
        int i=0,j=0,ans=0;
        int sum=0;
        for(;j<cost.length;j++){
            sum+=cost[j];
            while(sum>maxCost) sum-=cost[i++];
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}