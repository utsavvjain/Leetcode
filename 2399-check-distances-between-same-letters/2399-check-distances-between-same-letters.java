class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey((int)s.charAt(i))){
                map.put((int)s.charAt(i),i-1-map.get((int)s.charAt(i)));
                if(map.get((int)s.charAt(i))!=distance[s.charAt(i)-'a']) return false;                 
            } 
            else map.put((int)s.charAt(i),i);
        }
        return true;
    }
}