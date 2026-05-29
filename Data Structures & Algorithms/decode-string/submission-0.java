import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        // Stack to keep track of the multipliers (counts)
        Stack<Integer> countStack = new Stack<>();
        // Stack to keep track of the string segments before the brackets
        Stack<StringBuilder> stringStack = new Stack<>();
        
        // Tracks the current string segment being built
        StringBuilder currentString = new StringBuilder();
        // Tracks the current multiplier being built (for multi-digit numbers)
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Formulate the complete number (handles multi-digits like 12, 100)
                k = k * 10 + (ch - '0');
                
            } else if (ch == '[') {
                // Push current snapshot to stacks to process the nested inner string
                countStack.push(k);
                stringStack.push(currentString);
                
                // Reset states for the upcoming inner segment
                currentString = new StringBuilder();
                k = 0;
                
            } else if (ch == ']') {
                // Bracket ends: pop the multiplier and the parent string segment
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Append the current inner string 'repeatTimes' to the parent segment
                String repeatedSegment = currentString.toString().repeat(repeatTimes);
                decodedString.append(repeatedSegment);
                
                // Set the result back to current working string
                currentString = decodedString;
                
            } else {
                // Regular alphabet character
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }
}
