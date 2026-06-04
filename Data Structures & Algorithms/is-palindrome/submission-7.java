class Solution {
    public boolean isPalindrome(String s) {
        String original = new String(s.replaceAll("[\\p{Punct}\\s]", "").toLowerCase());
        char[] strArr = s.replaceAll("[\\p{Punct}\\s]", "").toLowerCase().toCharArray();

        Integer lp=0;
        Integer rp=strArr.length - 1;

        while(lp<rp){
            char temp = strArr[lp];
            strArr[lp] = strArr[rp];
            strArr[lp] = strArr[rp];
            lp++;
            rp--;
        }

        String revStr = String.valueOf(strArr);
        System.out.println(revStr);
        return original.equals(revStr);
    }
}
