class Solution {
    public boolean validUtf8(int[] data) {
       int bytesToProcess=0;
        for(int i=0;i<data.length;i++){
            String bRepr=Integer.toBinaryString(data[i]);
bRepr=bRepr.length() >= 8 ? bRepr.substring(bRepr.length() - 8): "00000000".substring(bRepr.length() % 8) + bRepr;
            
            if(bytesToProcess==0){
                 for(int j=0;j<bRepr.length() && bRepr.charAt(j)!='0';j++) bytesToProcess+=1;
                if(bytesToProcess==0) continue;
                    if(bytesToProcess>4 || bytesToProcess==1) return false;
            }
            else{
                if(bRepr.substring(0,2).equals("10")==false) return false;
            }
        bytesToProcess-=1;
        }
        return bytesToProcess==0;
    }
}