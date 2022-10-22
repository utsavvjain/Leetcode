class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";
        Map<Character, Integer> tMap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int charSize=tMap.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character,Integer> sMap=new HashMap<>();
        int[] ans = { -1, 0, 0 };
        while(r<s.length()){
            char c=s.charAt(r);
            sMap.put(c,sMap.getOrDefault(c,0)+1);
            
            if(tMap.containsKey(c) && sMap.get(c).intValue()==tMap.get(c).intValue()){
                formed++;
            }
            while(l<=r && formed==charSize){
                char ch=s.charAt(l);
                if(ans[0]==-1 || ans[0]>r-l+1){
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                sMap.put(ch,sMap.getOrDefault(ch,0)-1);
                if(tMap.containsKey(ch) && sMap.get(ch).intValue()<tMap.get(ch).intValue()){
                     formed--;
                  }
             l++;   
            }
            r++;
        }
        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }
}