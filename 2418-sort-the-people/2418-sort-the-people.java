class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> treeMap=new TreeMap<>((a,b)->b-a);
        for(int i=0;i<names.length;i++) treeMap.put(heights[i],names[i]);
        String ans[]=new String[names.length];
        int i=0;
        for(Map.Entry<Integer,String> e : treeMap.entrySet()) ans[i++]=e.getValue();
        return ans;
    }
}