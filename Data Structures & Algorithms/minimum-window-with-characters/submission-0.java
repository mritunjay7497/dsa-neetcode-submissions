class Solution {
    public String minWindow(String s, String t) {

        int[] charCount = new int[256];
        int lptr=0;
        int rptr=0;
        int minLength = Integer.MAX_VALUE;
        String minSubStr = "";
        int count = 0;

        // pre-fill the frequency of each characters from string t
        for(int i=0; i<t.length(); i++){
            charCount[t.charAt(i)]+=1;
        }

        while(rptr<s.length()){
            // if count value is +ve, it exists in t string
            if(charCount[s.charAt(rptr)] > 0){
                count+=1;
            }
            charCount[s.charAt(rptr)]--;

            // if count = t.length, means all chars of t are present in current substring
            while(count == t.length()){
                 if (rptr - lptr + 1 < minLength) {
                    minLength = rptr - lptr + 1;
                    minSubStr = s.substring(lptr, rptr + 1);
                }
                charCount[s.charAt(lptr)]++;
                if(charCount[s.charAt(lptr)] > 0){
                    count--;
                }
                lptr+=1;
            }
            rptr+=1;
        }
        return minSubStr;
    }
}
