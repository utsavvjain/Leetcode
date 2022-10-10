class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder sb=new StringBuilder(palindrome);
        if(sb.length()==1) return "";
        int n=sb.length()/2;
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='a') {
                if(i!=n-1) continue;
                sb.setCharAt(sb.length()-1,'b');
                return sb.toString();
                
            }
            char oldChar=sb.charAt(i);
            sb.setCharAt(i,'a');
            return sb.toString();
        }
        return "";
    }
}