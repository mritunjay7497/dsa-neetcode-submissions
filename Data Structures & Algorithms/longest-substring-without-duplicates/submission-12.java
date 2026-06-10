class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        char[] strChar = s.toCharArray();
        int length = s.length();
        int maxLength = 0;


// Bruteforce


        // for(int i=0; i<length; i++){
        //     String subStr = "";
        //     Map<Character, Integer> map =  new HashMap<>();
        //     for(int j=i; j<length; j++){

        //         if(map.get(strChar[j]) != null){
        //             break;
        //         }
        //         subStr+=strChar[j];
        //         maxLength = maxLength > subStr.length() ? maxLength : subStr.length();
        //         map.put(strChar[j],1);
        //         // System.out.println(subStr);
        //         // System.out.println(maxLength);

        //     }
        // }


// Optimal 2-pointer

        int lptr = 0;
        int rptr = 0;

        Map<Character,Integer> map = new HashMap<>();
        while(rptr<length){

            if(map.get(strChar[rptr]) != null && map.get(strChar[rptr]) >= lptr){
                lptr = map.get(strChar[rptr]) + 1;
            }
            map.put(strChar[rptr], rptr);
            maxLength = Math.max(rptr-lptr+1,maxLength);
            rptr++;

        }
        return maxLength;
    }
}
