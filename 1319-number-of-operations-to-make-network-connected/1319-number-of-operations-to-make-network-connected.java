
class Solution {
    int ans;
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
        ans-=1;
    }
    public int find(int i){
        if(i==set[i]) return i;
        return set[i]=find(set[i]);
    }
}
    public int makeConnected(int n, int[][] connections) {
    ans=n;
     if(connections.length<n-1) return -1;   
        DisjoinSet dsu=new DisjoinSet(n);
        for(int i=0;i<connections.length;i++){
            dsu.union(connections[i][0],connections[i][1]);
        }
        return ans-1;
    }
}