class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lp = 0;
        int rp = 1;
        while(rp<prices.length){
            if(prices[lp]<prices[rp]){
                int currentProfit = prices[rp]-prices[lp];
                maxProfit = maxProfit > currentProfit ? maxProfit : currentProfit;
            }else{
                lp=rp;
            }
            rp++;
        }
        return maxProfit;
    }
}
