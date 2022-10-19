class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)->{
            if(a.getValue()==b.getValue()){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue()-a.getValue();
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        List<String> ans=new LinkedList<>();
        for(int i=0;i<k && pq.isEmpty()==false;i++) ans.add(pq.poll().getKey());
        return ans;
    }
}