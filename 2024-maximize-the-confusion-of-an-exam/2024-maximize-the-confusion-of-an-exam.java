class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {        
        int a=k;
        int l=0,r,ans=Integer.MIN_VALUE;
        for(r=0;r<answerKey.length();r++){
            if(answerKey.charAt(r)=='F') k-=1;
            if(k<0){
                while(answerKey.charAt(l++)=='T');
                k+=1;
                //l+=1;
            } 
            ans=Math.max(ans,r-l+1);
        }
        l=0;
        k=a;
        for(r=0;r<answerKey.length();r++){
            if(answerKey.charAt(r)=='T') k-=1;
            if(k<0){
                while(answerKey.charAt(l++)=='F');
                k+=1;
                //l+=1;
            } 
            ans=Math.max(ans,r-l+1);
        }

        return ans;
    }
}