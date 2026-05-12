class Solution {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupCheck = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(dupCheck.contains(nums[i])){
                return true;
            }else{
                dupCheck.add(nums[i]);
            }
        }
        return false;
    }
}