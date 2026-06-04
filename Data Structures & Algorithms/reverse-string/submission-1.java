class Solution {
    public void reverseString(char[] s) {
       Integer lp = 0;
       Integer rp = s.length - 1;
       while(lp<rp){
        char temp = s[rp];
        s[rp] = s[lp];
        s[lp] = temp;
        lp++;
        rp--;
       }
    }
}