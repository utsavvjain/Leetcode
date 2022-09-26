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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        DisjoinSet ds=new DisjoinSet(n);
        char strArray[]=s.toCharArray();
        for(List<Integer> pair : pairs){
            ds.union(pair.get(0),pair.get(1));
        }
        for(int i=0;i<n;i++){
            int parentId=ds.find(i);
            PriorityQueue<Character> pq=map.getOrDefault(parentId,new PriorityQueue<>());
            pq.offer(strArray[i]);
            map.putIfAbsent(parentId,pq);
        }
        for(int i=0;i<n;i++){
            int parentId=ds.find(i);
            strArray[i]=map.get(parentId).poll();
        }
        return new String(strArray);
    }
}