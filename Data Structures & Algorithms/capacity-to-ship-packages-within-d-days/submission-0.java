class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minWeightCapacity = maxWeight(weights);
        int maxWeightCapacity = sumOfAllWeights(weights);

        int low = minWeightCapacity;
        int high = maxWeightCapacity;

        while(low<=high){
            int mid = low + (high-low)/2;
            int daysTaken = calculateDays(mid,weights);
            if(daysTaken <= days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    // max weight capacity via which ship can transfer all weights in 1 day
    private int sumOfAllWeights(int[] weights){
        return Arrays.stream(weights).sum();
    }

    // min weight capacity of ship so trhat it can transfer all the weights, including heaviest
    private int maxWeight(int[] weights){
        return Arrays.stream(weights).max().getAsInt();
    }

    // days required according to min weiht capacity
    private int calculateDays(int lwc, int[] weights){
        int days = 1;
        int load = 0;

        for(int i=0; i<weights.length; i++){
            load += weights[i];
            if(load <= lwc){
                continue;
            }else{
                load = weights[i];
                days++;
            }
        }
        return days;
    }
}