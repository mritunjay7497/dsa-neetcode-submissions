class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFrequency = 0;
        

        for(int i=0; i<s.length(); i++){
            int[] charCount = new int[26];
            for(int j=i; j<s.length(); j++){
                // increament the char count of the current character
                charCount[s.charAt(j) - 'A']++;

                // calcluate the max-frequency for the characters encountered yet
                maxFrequency = Math.max(maxFrequency, charCount[s.charAt(j) - 'A']);

                // number of change which we can do is length - maxFrequency and it should be <=k
                int changes = (j-i+1) - maxFrequency;
                if(changes<=k){
                    maxLength = Math.max(maxLength,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }
}
