class StockSpanner {
    ArrayList<Integer> ar;

    public StockSpanner() {
        ar = new ArrayList<>();
    }
    
    public int next(int price) {
        int count = 1;
        for(int i=ar.size()-1; i>=0; i--){
            if(ar.get(i)<=price){
                count+=1;
            }else{
                break;
            }
        }
        ar.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */