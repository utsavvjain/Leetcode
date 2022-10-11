class Solution {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num : nums){
            if(list.isEmpty() || num>list.get(list.size()-1)) list.add(num);
            else{
                int position=Collections.binarySearch(list,num);
                if(position<0) position=(-position)-1;
                list.set(position,num);
            }
        }
        return list.size()>=3;
    }
}