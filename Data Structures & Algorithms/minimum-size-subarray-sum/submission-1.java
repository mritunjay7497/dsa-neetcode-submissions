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
            int length = rptr-lptr+1;

            if(sum>=target){
                minLength = Math.min(minLength,length);
            }

            while(sum>=target){
                sum-=nums[lptr];
                lptr++;
                length = rptr-lptr+1;
                if(sum>=target){
                    minLength = Math.min(minLength,length);
                }
            }
            rptr++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}