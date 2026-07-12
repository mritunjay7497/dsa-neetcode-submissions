class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-2] != nums[n-1]) return nums[n-1];

        int low = 1;
        int high = n-2;

        while(low<=high){
            // if the single element is in the righ half, there will be (even,odd) idx on the left half
            // we will eliminate the left half

            // If single elment is in the left half, there will be (odd,even) idx on the right half.
            // we will eliminate the right half

            int mid = low+(high-low)/2;

            if(nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid]){
                return nums[mid];
            }

            if(mid%2 == 0){
                if(nums[mid-1] == nums[mid]){
                    // element is on the left side of mid
                    // eliminate the right side of the mid
                    high = mid - 1;
                }else if(nums[mid+1] == nums[mid]){
                    // element is on the right side of the mid
                    // eliminate the left side
                    low = mid + 2;
                }
            }else{
                if(nums[mid-1] == nums[mid]){
                    // element is on the right side of mid
                    // eliminate the left side of the mid
                    low = mid + 1;
                }else if(nums[mid+1] == nums[mid]){
                    // element is on the left side of the mid
                    // eliminate the right side
                    high = mid - 2;
                }
            }
            
        }
        return nums[low];
    }
}