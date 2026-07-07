class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;

            // Identify the sorted half
            if(nums[mid] <= nums[high]){
                // upper half is sorted
                if(nums[mid] <= target && target<= nums[high]){
                    // target lies in upper half
                    low = mid + 1;
                }else{
                    // target not found in upper half
                    high = mid - 1;
                }
            }else if(nums[mid] >= nums[low]){
                //lower half is sorted
                if(nums[low] <= target && target <= nums[mid]){
                    // target lies in lower half
                    high = mid - 1;
                }else{
                    // target not found in lower half
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
