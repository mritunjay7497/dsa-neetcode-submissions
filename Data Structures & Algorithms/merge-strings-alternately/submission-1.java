class Solution {
    public String mergeAlternately(String word1, String word2) {
        Integer size = Math.min(word1.length(),word2.length());
        Integer wp1 = 0;
        Integer wp2 = 0;
        String ans = new String();

        while(wp1<size && wp2<size){
            ans+=word1.charAt(wp1);
            ans+=word2.charAt(wp2);
            wp1++;
            wp2++;
        }

        // add remaining
        if(word1.length() > size){
            while(wp1<word1.length()){
                ans+=word1.charAt(wp1);
                wp1++;
            }
        }
        if(word2.length() > size){
            while(wp2<word2.length()){
                ans+=word2.charAt(wp2);
                wp2++;
            }
        }
        return ans;
    }
}