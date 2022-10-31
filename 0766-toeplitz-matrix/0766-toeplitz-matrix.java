class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;        
        for(int i=m-1;i>=0;i--){
            int first=matrix[i][0];
            for(int k=i+1,j=1;k<m && j<n;k++,j++) {
                if(first!=matrix[k][j]) return false;
            }
        }
        for(int i=1;i<n;i++){
            int first=matrix[0][i];
            for(int k=i+1,j=1;k<n && j<m;k++,j++){
                if(first!=matrix[j][k]) return false;
            }
        }
        return true;
    }
}