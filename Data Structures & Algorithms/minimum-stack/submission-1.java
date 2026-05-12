class MinStack {

    public Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack();
    }
    
    public void push(int val) {
        minStack.push(val);
        System.out.println(minStack + "PUSH");
    }
    
    public void pop() {
        minStack.pop();
        System.out.println(minStack + "POP");
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        System.out.println(minStack + "MIN");
        Stack<Integer> copy = (Stack<Integer>) minStack.clone();
        int copySize = copy.size();

        int min = copy.peek();

        for(int i=0; i<copySize; i++){
            System.out.println(copy + "CPY-prev");

            int curr = copy.pop();

            System.out.println(copy + "CPY-after");

            if(min>curr){
                min = curr;
            }
        }
        return min;
    }
}
