class Solution {
    private int[] findNGEIdx(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> idxStack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // 1. Remove elements smaller than or equal to current from stack
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
                idxStack.pop();
            }

            // 2. If stack is empty, no greater element exists to the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // 3. Top of stack is the next greater element
                result[i] = idxStack.peek();
            }

            // 4. Push current element onto stack for future comparisons
            stack.push(arr[i]);
            idxStack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temp) {
        int[] NGEIdx = findNGEIdx(temp);
        int[] result = new int[temp.length];

        for(int i = 0; i < temp.length; i++){
            if(NGEIdx[i] == -1){
                result[i] = 0;
            } else {
                result[i] = NGEIdx[i] - i;
            }
        }
        return result;
    }
}
