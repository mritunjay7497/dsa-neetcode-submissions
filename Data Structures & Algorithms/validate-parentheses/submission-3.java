class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> charSt = new Stack<>();
        boolean valid = false;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                charSt.push(arr[i]);
            }else{
                if(charSt.isEmpty()){
                    return false;
                }
                char prevBracket = charSt.pop();
                char currentBracket = arr[i];
                valid = isComplimentaryPair(prevBracket,currentBracket);
                if(valid){
                    continue;
                }else{
                    break;
                }
            }
        }
        return valid && charSt.isEmpty();
    }

    private boolean isComplimentaryPair(char prev, char current){
        if(prev == '(' && current == ')') return true;
        if(prev == '[' && current == ']') return true;
        if(prev == '{' && current == '}')return true;
        return false;
    }
}
