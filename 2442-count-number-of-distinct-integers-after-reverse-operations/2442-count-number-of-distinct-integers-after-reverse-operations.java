class Solution {
    public int reverse(int num){
        int ans=0;
        while(num>0){
            ans=ans*10+num%10;
            num=num/10;
        }
        return ans;
    }
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
            set.add(reverse(num));            
        }
        return set.size();
    }
}