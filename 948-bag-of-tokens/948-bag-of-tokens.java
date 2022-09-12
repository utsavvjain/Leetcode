class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
     Arrays.sort(tokens);
        int beg=0,end=tokens.length-1,score=0,maxi=0;
        while(beg<=end){
            if(power>=tokens[beg]) {
                power-=tokens[beg++];
                maxi=Math.max(maxi,++score);                
            }
            else if(score>0){
                power+=tokens[end--];
                score--;
            }
            else break;
        }
        return maxi;
    }
}