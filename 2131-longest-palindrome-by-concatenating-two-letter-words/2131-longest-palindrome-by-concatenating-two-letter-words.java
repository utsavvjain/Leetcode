class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String word : words) map.put(word,map.getOrDefault(word,0)+1);
        int wordsCount=0;
        boolean hasMiddle=false;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            String word=e.getKey();
            int count=e.getValue();
            if(word.charAt(0)==word.charAt(1)){
                if(count%2==0) wordsCount+=count;
                else {
                    wordsCount+=(count-1);
                hasMiddle=true;
                }
            }
            else if(word.charAt(0)<word.charAt(1)){
                String reverse=word.charAt(1)+""+word.charAt(0);
                if(map.containsKey(reverse)) wordsCount+=(2*Math.min(count,map.get(reverse)));
            }
        }
        if(hasMiddle) wordsCount+=1;
        return 2*wordsCount;
    }
}