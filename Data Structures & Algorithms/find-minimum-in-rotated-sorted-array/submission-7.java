class Solution {
    public int findMin(int[] nums) {
        // O(N) trivial approach
        // int minVal = nums[0];
        // for(int i=0; i<nums.length-1; i++){
        //     if(nums[i] > nums[i+1]){
        //         minVal =  nums[i+1];
        //         break;
        //     }
        // }
        // return minVal;

        // O(logN) optimum approach
        int low = 0;
        int high = nums.length - 1;
        int mid = (high+low)/2;
        
        while(low<high){
            mid = low + (high-low)/2;
            if(nums[mid] > nums[high]){
                // min is between mid and high
                // eliminate left half
                low = mid + 1;
            }else if(nums[mid] < nums[high]){
                // min is between low and mid or at mid
                // eliminate right half
                high = mid;
            }
        }
        return nums[low];
    }
}
