class Solution {
    char []set;
    
    public void union(char a,char b){
        if(a==b) return;
        char parA=find(a);
        char parB=find(b);
        set[parA]=parB;        
    }
    public char find(char a){
        if(a==set[a]) return a;
        return set[a]=find(set[a]);
    }
    public boolean equationsPossible(String[] equations) {
        set=new char[256];
        for(char i=0;i<256;i++) set[i]=i;
        List<String> equals=new LinkedList<>();
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