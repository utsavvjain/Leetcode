class Solution {
    char []set;
    
    public void union(char a,char b){
        if(a==b) return;
        char parA=find(a);
        char parB=find(b);
        set[parA-'a']=parB;        
    }
    public char find(char a){
        if(a==set[a-'a']) return a;
        return set[a-'a']=find(set[a-'a']);
    }
    public boolean equationsPossible(String[] equations) {
        set=new char[26];
        for(char i='a';i<='z';i++) set[i-'a']=i;
        List<String> notEquals=new LinkedList<>();
        for(String eq : equations){
            if(eq.contains("!=")) notEquals.add(eq);
            else union(eq.charAt(0),eq.charAt(3));            
        }
        for(String str : notEquals){
            if(find(str.charAt(0))==find(str.charAt(3))) return false;
        }
        return true;
    }
}