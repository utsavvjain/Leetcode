class Solution {
    public String breakPalindrome(String palindrome) {
        StringBuilder sb=new StringBuilder(palindrome);
        if(sb.length()==1) return "";
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='a') {
                if(i!=sb.length()-1) continue;
                sb.setCharAt(i,'b');
                return sb.toString();
                
            }
            char oldChar=sb.charAt(i);
            for(char chr='a';chr<oldChar;chr++){
                sb.setCharAt(i,chr);
                if(!isPalindrome(sb)) return sb.toString();
            }
            sb.setCharAt(i,oldChar);
        }
        return "";
    }
    public boolean isPalindrome(StringBuilder s){
        for(int i=0,j=s.length()-1;i<j;i++,j--) if(s.charAt(i)!=s.charAt(j)) return false;
        return true;
    }
}