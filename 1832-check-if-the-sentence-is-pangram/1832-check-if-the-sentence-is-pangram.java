class Solution {
    public boolean checkIfPangram(String sentence) {
        int VAL=67108863;
        int bit=0;
        for(int i=0;i<sentence.length();i++){
            bit|=(1 << (sentence.charAt(i)-'a'));
        }
        return VAL==bit;
    }
}