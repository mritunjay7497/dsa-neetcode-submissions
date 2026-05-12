class Solution {
    public void reverseString(char[] s) {
        int lp = 0;
        int rp = s.length - 1;

        while(lp<rp){
            char tmp = s[lp];
            s[lp] = s[rp];
            s[rp] = tmp;
            lp++;
            rp--;
        }
    }
}