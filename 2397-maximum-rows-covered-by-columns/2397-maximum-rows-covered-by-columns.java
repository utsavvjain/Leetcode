class Solution {    
    public int calculateNumberOfRows(int [][]mat,Set<Integer> cols){
        int n=mat.length,m=mat[0].length;
        int cnt=0;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++) {
                if(mat[i][j]==1 && !cols.contains(j)) break;
            }
            if(j==m) cnt+=1;
        }
        return cnt;
    }
    public int maximumRows(int[][] mat, int cols,Set<Integer> col,int colNum,int n) {
        if(cols==0 ){
            return calculateNumberOfRows(mat,col);            
        }
        if(colNum>=n) return Integer.MIN_VALUE;
        
        //pick
        col.add(colNum);
        int pick=maximumRows(mat,cols-1,col,colNum+1,n);        
        col.remove(colNum);
        
        //not pick
        int notPick=maximumRows(mat,cols,col,colNum+1,n);                
        return Math.max(pick,notPick);
    }
    public int maximumRows(int[][] mat, int cols) {
        Set<Integer> col=new HashSet<>();
        return maximumRows(mat,cols,col,0,mat[0].length);
    }
}