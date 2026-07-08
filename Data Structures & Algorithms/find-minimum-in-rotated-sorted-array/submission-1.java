class Solution {
    public int findMin(int[] nums) {
        // O(N) trivial approach
        int minVal = nums[0];
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                minVal =  nums[i+1];
                break;
            }
        }
        return minVal;
    }
}
