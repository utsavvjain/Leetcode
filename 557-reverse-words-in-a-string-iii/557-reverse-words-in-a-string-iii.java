class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                while(!stk.isEmpty()) sb.append(stk.pop());
                sb.append(' ');
            }
            else stk.push(s.charAt(i));
        }
        while(!stk.isEmpty()) sb.append(stk.pop());        
        return sb.toString();
    }
}