class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        List<List<Integer>> ans=new LinkedList<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
            set.add(words[i].length());
        }
        for(int i=0;i<words.length;i++){
            int length=words[i].length();
            if(length==1){
                if(map.containsKey("")){
                    ans.add(Arrays.asList(i,map.get("")));
                    ans.add(Arrays.asList(map.get(""),i));
                }
                continue;
            }
            String reverse=new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(reverse) && i!=map.get(reverse)) ans.add(Arrays.asList(i,map.get(reverse)));
            for(int k : set){
                if(k==length) break;
                if(isPalindrome(0,length-1-k,reverse)){
                    String sbStr=reverse.substring(length-k);
                    if(map.containsKey(sbStr)) ans.add(Arrays.asList(i,map.get(sbStr)));
                }
                if(isPalindrome(k,length-1,reverse)){
                    String sbStr=reverse.substring(0,k);
                    if(map.containsKey(sbStr)) ans.add(Arrays.asList(map.get(sbStr),i));
                }
                
            }
            
        }
        return ans;
    }
    private boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    } 
}