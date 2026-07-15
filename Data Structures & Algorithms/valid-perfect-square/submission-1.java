class Solution {
    public boolean isPerfectSquare(int num) {
        // perfect square of n lies between 0 to n/2
        int low = 1;
        int high = num/2;

        while(low<=high){
            int mid = low + (high-low)/2;
            
            System.out.println(mid);
            long square = (long) mid*mid;
            if(square == num) return true;
            if(square < num){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low*low == num;
    }
}