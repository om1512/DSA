class StockSpanner {
    ArrayList<Integer> list = new ArrayList<>();
    public int next(int price) {
        int span = 1, index=list.size()-1;
        while(index>=0 && list.get(index) <= price){
            index--;
            span++;
        }
        list.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */