class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMaxTime(piles);

        while(low<=high){

            int mid = low+(high-low)/2;
            int currentTime = timeTaken(piles,mid);
            
            if(currentTime <= h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private int timeTaken(int[] piles, int hourly){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time += (piles[i] + hourly - 1) / hourly;        
        }
        return time;
    }

    private int getMaxTime(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
}
