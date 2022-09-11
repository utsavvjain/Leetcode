class Solution {
    public int partitionString(String s) {
        HashSet<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.clear();
                count+=1;
            }
                set.add(s.charAt(i));            
        }
        return count+1;
    }
}