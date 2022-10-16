class Solution {
    public int reverse(int num){
        int ans=0;
        while(num>0){
            ans=ans*10+num%10;
            num=num/10;
        }
        return ans;
    }
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=num;i>=num/2;i--){
            if(i+reverse(i)==num) return true;
        }
        return false;
    }
}