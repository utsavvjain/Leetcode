class Solution {
    public void numsSameConsecDiff(int n, int k,List<Integer> ans,int num) {
        if(n==0){
            ans.add(num);
            return;
        }
        int lastDigit=num%10;
        for(int i=0;i<=9;i++) if(Math.abs(i-lastDigit)==k) numsSameConsecDiff(n-1,k,ans,num*10+i);
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans=new LinkedList<>();
        for(int i=1;i<10;i++){
            numsSameConsecDiff(n-1,k,ans,i);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();        
    }
}