
class Trie{
    class TrieNode{
    private TrieNode[] link;
    private boolean end;
    private int count;
    public TrieNode(){
        link=new TrieNode[26];
        end=false;
        count=0;
    }
    public boolean containsKey(char a){
        return link[a-'a']!=null;
    }
    public TrieNode get(char a){
        return link[a-'a'];
    }
    public TrieNode put(char a,TrieNode trieNode){
        return link[a-'a']=trieNode;
    }
    public void setEnd(){
        end=true;
    }
    public boolean isEnd(){
        return end;
    }
    public void addCount(char c){
        if(link[c-'a']==null) return;
        link[c-'a'].count+=1;
    }
    public int getCount(char c){
        return (link[c-'a']!=null)?link[c-'a'].count:0;
    }
}

    private TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){            
            if(!node.containsKey(word.charAt(i))) node.put(word.charAt(i),new TrieNode());
            node.addCount(word.charAt(i));
            node=node.get(word.charAt(i));
        }
    }
    public int count(String word){
        TrieNode node=root;
        int cnt=0;
        for(int i=0;i<word.length();i++){            
            cnt+=node.getCount(word.charAt(i));
            node=node.get(word.charAt(i));
        }
        return cnt;
    }
    
}
class Solution { 
    public int[] sumPrefixScores(String[] words) {
        Trie trie=new Trie();
        for(String word : words) trie.insert(word);
        int ans[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]+=trie.count(words[i]);
        }
        return ans;
    }
}