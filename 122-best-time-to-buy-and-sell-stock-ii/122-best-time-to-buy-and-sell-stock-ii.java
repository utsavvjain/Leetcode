class Solution {
    public int maxProfit(int[] prices) {
        int buy=0,sell=0;
        int profit=0;
        for(int i=0;i<prices.length;){
            while(i<prices.length-1 && prices[i]>prices[i+1]) i+=1;
            buy=prices[i];
            i+=1;
            
            while(i<prices.length-1 && prices[i]<prices[i+1]){
              i+=1;  
            } 
            if(i<prices.length) {
                profit+=prices[i]-buy;
            }
            i+=1;
        }
        return profit;
    }
}