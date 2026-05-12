class MinStack {

    public Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        Stack<Integer> copy = (Stack<Integer>) minStack.clone();
        int copySize = copy.size();

        int min = copy.peek();

        for(int i=0; i<copySize; i++){

            int curr = copy.pop();


            if(min>curr){
                min = curr;
            }
        }
        return min;
    }
}
