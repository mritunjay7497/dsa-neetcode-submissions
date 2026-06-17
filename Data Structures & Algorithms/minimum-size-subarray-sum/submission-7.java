class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength=Integer.MAX_VALUE;

//        Bruteforce approach
        // for(int i=0; i<nums.length; i++){
        //     int sum=0;
        //     for(int j=i; j<nums.length; j++){
        //         sum+=nums[j];
        //         if(sum>=target){
        //             minLength = Math.min(minLength,j-i+1);
        //         }
        //     }
        // }

        // Optimal approach
        int rptr=0;
        int lptr=0;
        int sum=0;
        
        while(rptr<nums.length){
            sum+=nums[rptr];

            if(sum>=target){
                minLength = Math.min(minLength,rptr-lptr+1);
            }

            while(sum>=target){
                sum-=nums[lptr];
                lptr++;
                if(sum>=target){
                    minLength = Math.min(minLength,rptr-lptr+1);
                }
            }
            rptr++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}