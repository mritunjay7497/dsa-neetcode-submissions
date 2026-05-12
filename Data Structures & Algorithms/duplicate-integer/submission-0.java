class Solution {

    private Set<Integer> dupCheck = new HashSet<>();

    public boolean hasDuplicate(int[] nums) {
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