class Solution {
    public boolean isPalindrome(String s) {
        String modString = s.toLowerCase().replaceAll("[^a-z0-9]","");

        if(modString.length() > 1){
            Integer left = 0;
        Integer right = modString.length()-1;

        while(left<right){
            if(modString.charAt(left) != modString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        } return true;
    }
}
