class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        // sqrt will be less than int/2
        int high = x/2;
        int low = 0;


        while(low <= high){
            int mid = (low + high)/2;
            long square = (long) mid * (long) mid;
            if(square < x){
                low = mid+1;
            }else if(square > x){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return high;
    }
}