class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> ansMap = new HashMap();

        for(Integer i=0; i<nums.length; i++){
            ansMap.put(nums[i],i);
        }

        for(Integer i=0; i<nums.length; i++){
            Integer compVal = target - nums[i];
            Integer compIdx = ansMap.get(compVal);
            if(compIdx != null && compIdx != i){
                return new int[]{i, compIdx};
            }
        }
        return null;
    }
}
