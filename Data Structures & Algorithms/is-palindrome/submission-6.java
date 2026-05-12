class Solution {
    public boolean isPalindrome(String s) {
        // String modString = s.toLowerCase().replaceAll("[^a-z0-9]","");


        if(s.length() > 1){
            Integer left = 0;
            Integer right = s.length()-1;

            while(left<right){
                if(!Character.isLetterOrDigit(s.toLowerCase().charAt(left))){
                    left++;
                    continue;
                }

                if(!Character.isLetterOrDigit(s.toLowerCase().charAt(right))){
                    right--;
                    continue;
                }

                if(s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        return true;
    }
}
