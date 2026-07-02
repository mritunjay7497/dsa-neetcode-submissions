class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int resArrLen = nums.length-k+1;
        int[] resArr = new int[resArrLen];

        // bruteforce
        for(int i=0; i<nums.length-k+1; i++){
            int max = nums[i];
            for(int j=i; j<i+k; j++){
                max = Math.max(max,nums[j]);
                resArr[i] = max;
            }
        }
        return resArr;
    }
}
