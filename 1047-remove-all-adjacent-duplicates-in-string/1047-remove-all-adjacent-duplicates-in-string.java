class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stk.isEmpty() || stk.peek()!=s.charAt(i)) stk.push(s.charAt(i));
            else if(!stk.isEmpty())stk.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()) sb.insert(0,stk.pop());
        return sb.toString();
    }
}