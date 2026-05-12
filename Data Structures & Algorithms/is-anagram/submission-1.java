class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> firstStrCharCount = getCharCountMap(s);
        Map<Character,Integer> secondStrCharCount = getCharCountMap(t);

        return firstStrCharCount.equals(secondStrCharCount);

    }

    private Map<Character,Integer> getCharCountMap(String str){
        Map<Character,Integer> charCountMap = new HashMap<>();

        // Store map of each character count in first string
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(charCountMap.containsKey(c)){
                charCountMap.put(c, charCountMap.get(c) + 1);
            }else{
                charCountMap.put(c, 1);
            }
        }

        return charCountMap;
    }
}
