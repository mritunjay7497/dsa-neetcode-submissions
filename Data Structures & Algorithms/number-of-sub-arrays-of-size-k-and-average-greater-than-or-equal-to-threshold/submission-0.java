class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int lptr=0;
        int rptr=0;
        int count=0;
        
        while(rptr<arr.length){
            int size = rptr-lptr+1;
            
            while(size>k){
                lptr++;
                size = rptr-lptr+1;
            }
            
            if(size==k && getAvg(Arrays.copyOfRange(arr,lptr,rptr+1)) >= threshold){
                count++;
            }

            rptr++;
        }
        return count;
    }

    private double getAvg(int[] arr){
        return Arrays.stream(arr).average().orElse(0.0);
    }
}