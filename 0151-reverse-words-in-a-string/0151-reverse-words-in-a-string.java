class Solution {
    public String reverseWords(String s) {
        String ans="";
        int i=0,j;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)==' ') i++;
            j=i;
            while(j<s.length() && s.charAt(j)!=' ') j++;
            ans=s.substring(i,j)+" "+ans;
            i=j+1;
        }
        return ans.trim();
    }
}