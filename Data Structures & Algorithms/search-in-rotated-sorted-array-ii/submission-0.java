class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return true;

            // Keep shrinking the search sapce if nums[low] == nums[mid] == nums[high]

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low+=1;
                high-=1;
                continue;
            }

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
            }else{
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
        return false;
    }
}
