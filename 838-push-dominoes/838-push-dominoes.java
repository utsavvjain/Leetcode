class Solution {
    public String pushDominoes(String dominoes) {
        int right=-1;
        int left=0;
        char str[]=dominoes.toCharArray();
        for(left=0;left<dominoes.length();left++){
            if(str[left]=='L'){
                if(right==-1){
                    for(int i=left-1;i>=0 && str[i]=='.';i--) str[i]='L';                    
                }
                else{
                    for(int i=left-1,j=right+1;j<i;i--,j++){
                        str[i]='L';
                        str[j]='R';
                    }
                    right=-1;
                }                
            }
            if(str[left]=='R'){
                if(right!=-1) for(int i=right+1;i<left;i++) str[i]='R';
                right=left;
            }
         }
        if (right != -1) {
        for (int j = right + 1; j < str.length; ++j) str[j] = 'R';
    }
        return new String(str);
    }
}