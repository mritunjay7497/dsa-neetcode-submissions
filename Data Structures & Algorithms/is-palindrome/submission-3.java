class Solution {
    public boolean isPalindrome(String s) {
        String modString = s.toLowerCase().replaceAll("[^a-z0-9]","");
        if(modString.length() > 1){
            Integer left = 0;
        Integer right = modString.length()-1;
        Integer windowLength = right-left;
        boolean ans = false;

        while(windowLength>0){
            if(modString.charAt(left) == modString.charAt(right)){
                ans = true;
            }else{
                ans = false;
            }
            left++;
            right--;
            windowLength = right-left;
        }
        return ans;
        }else{
        return true;
    }
    }
}
