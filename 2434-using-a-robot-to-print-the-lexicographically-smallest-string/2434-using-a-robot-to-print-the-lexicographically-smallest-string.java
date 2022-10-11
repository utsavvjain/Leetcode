class Solution {
    public char smallestInRight(int freq[]){
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return (char)('a'+i);
        }
        return 'a';
    }
    public String robotWithString(String s) {
        Stack<Character> stk=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']+=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            stk.push(c);
            freq[c-'a']-=1;
            while(!stk.isEmpty() && stk.peek()<=smallestInRight(freq)){
                sb.append(stk.pop());
            }
        }
        while(!stk.isEmpty()){
                sb.append(stk.pop());            
        }
        return sb.toString();
    }
}