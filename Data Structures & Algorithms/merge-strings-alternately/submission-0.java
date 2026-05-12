class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        int ptr1 = 0;
        int ptr2 = 0;

        String ans = "";

        while(ptr1<word1Arr.length && ptr2<word2Arr.length){
            ans += word1Arr[ptr1];
            ans += word2Arr[ptr2];
            ptr1++;
            ptr2++;
        }

        if(ptr1==word1Arr.length){
            while(ptr2<word2Arr.length){
                ans+=word2Arr[ptr2];
                ptr2++;
            }
        }else{
            while(ptr1<word1Arr.length){
                ans+=word1Arr[ptr1];
                ptr1++;
            }
        }
        return ans;
    }
}