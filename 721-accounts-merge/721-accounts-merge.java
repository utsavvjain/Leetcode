class DisjoinSet{
    int set[];
    int rank[];
    public DisjoinSet(int size){
        set=new int[size];
        rank=new int[size];
        for(int i=0;i<size;i++) set[i]=i;
        Arrays.fill(rank,1);
    }
    public void union(int i,int j){
        int parI=find(i);
        int parJ=find(j);
        if(parI==parJ) return;
        if(rank[parJ]<rank[parI]){
            set[parI]=parJ;
            rank[parI]+=rank[parJ];
        }
        else{
            set[parJ]=parI;
            rank[parJ]+=rank[parI];            
        }
    }
    public int find(int i){
        if(i==set[i]) return i;
        return set[i]=find(set[i]);
    }
}

class Solution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjoinSet dsu=new DisjoinSet(accounts.size());
        HashMap<String,Integer> emails=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> acc=accounts.get(i);
            for(int j=1;j<acc.size();j++){
                if(emails.containsKey(acc.get(j))){
                    dsu.union(i,emails.get(acc.get(j)));
                }
                else{
                    emails.put(acc.get(j),i);
                }
            }
        }        
        Map<Integer,TreeSet<String>> map=new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> acc=accounts.get(i);
            int parent=dsu.find(i);
            map.putIfAbsent(parent,new TreeSet<>());
            map.get(parent).addAll(accounts.get(i).subList(1,accounts.get(i).size()));
            
        }                
        List<List<String>> ans=new LinkedList<>();
        for(int key : map.keySet()){
            String name=accounts.get(key).get(0);
            List<String> lst=new LinkedList<>(map.get(key));
            lst.add(0,name);
            ans.add(lst);
        }
        return ans;
        
    }
}