class Solution {
    public String makeGood(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stk.isEmpty() || Math.abs(stk.peek()-s.charAt(i))!=32) stk.push(s.charAt(i));
            else if(!stk.isEmpty()) stk.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!stk.isEmpty()) sb.insert(0,stk.pop());
        return sb.toString();
    }
}