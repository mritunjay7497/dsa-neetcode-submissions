class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] strChar = s.toCharArray();
        int length = s.length();
        int maxLength = 0;


        for(int i=0; i<length; i++){
            String subStr = "";
            Map<Character, Integer> map =  new HashMap<>();
            for(int j=i; j<length; j++){

                if(map.get(strChar[j]) != null){
                    break;
                }
                subStr+=strChar[j];
                maxLength = maxLength > subStr.length() ? maxLength : subStr.length();
                map.put(strChar[j],1);
                // System.out.println(subStr);
                // System.out.println(maxLength);

            }
        }
        return maxLength;
    }
}
