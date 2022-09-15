class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n=changed.length;
        if(n%2!=0) return new int[0];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int i : changed) map.put(i,map.getOrDefault(i,0)+1);
        
        int ans[]=new int[n/2];
        
        int i=0;
        
        for(int key : map.keySet()){
            if(map.get(key)>map.getOrDefault(key+key,0)) return new int[0];
            for(int j=0;j<map.get(key);j++) {
                ans[i++]=key;
                map.put(key+key,map.get(key+key)-1);
            }
        }
        return ans;
    }
}