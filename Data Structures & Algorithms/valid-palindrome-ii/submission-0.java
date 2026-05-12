class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();

        int lp = 0;
        int rp = arr.length - 1;

        while(lp<rp){
            if(arr[lp] == arr[rp]){
                lp++;
                rp--;
            }else{
                return isPalindrome(arr,lp+1,rp) || isPalindrome(arr, lp, rp-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int lp, int rp){
        while(lp<rp){
            if(arr[lp] == arr[rp]){
                lp++;
                rp--;
            }else{
                return false;
            }
        }
        return true;
    }
}