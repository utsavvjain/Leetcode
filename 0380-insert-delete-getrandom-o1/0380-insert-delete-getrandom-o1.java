class RandomizedSet {
    HashMap<Integer,Integer> map=new HashMap<>();
    LinkedList<Integer> list=new LinkedList<>();
    Random random=new Random();
    public RandomizedSet() {        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int pos=map.get(val);
        int n=list.size();
        if(pos<n-1){
            int temp=list.get(n-1);
            list.set(pos,temp);
            map.put(temp,pos);
        }   
        map.remove(val);
        list.remove(n-1);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */