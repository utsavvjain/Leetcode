class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-1;
        while(high-low+1>k){
            if(x-arr[low]<=arr[high]-x) high--;
            else low++;
        }
        List<Integer> ans=new LinkedList<>();
        for(int i=low;i<=high;i++) ans.add(arr[i]);
        return ans;
    }
}