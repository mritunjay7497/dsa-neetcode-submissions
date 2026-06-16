class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int lptr=0;
        int rptr=0;
        int count=0;
        int currentSum=0;
        
        while(rptr<arr.length){
            int size = rptr-lptr+1;

            currentSum += arr[rptr];

            if(size>k){
                currentSum -= arr[lptr];
                lptr++;
                size--;
            }

            if(size == k && currentSum >= size*threshold){
                count++;
            }
            
            rptr++;
        }
        return count;
    }
}