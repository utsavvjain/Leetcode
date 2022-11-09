class StockSpanner {
    private int index;
    private Stack<int []> stk;
    public StockSpanner() {
        index=-1;
        stk=new Stack<>();
    }
    
    public int next(int price) {
        index++;
        if(stk.isEmpty()){
            stk.push(new int[]{price,index});
            return 1;
        }
        while(!stk.isEmpty() && stk.peek()[0]<=price) stk.pop();
        int span=0;
        if(stk.isEmpty()) span=index+1;
        else span=index-stk.peek()[1];
        stk.push(new int[]{price,index});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */