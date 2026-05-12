class Solution {

    private boolean isOperator(String token){
        switch(token){
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    private boolean isOperand(String token){
        try{
            Integer currentInt = Integer.parseInt(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private Integer eval(int top1, int top2, String operator){
        switch(operator){
            case "+":
                return top2 + top1;
            case "-":
                return top2 - top1;
            case "*":
                return top2 * top1;
            case "/":
                return top2 / top1;
        }
        return null;
    }

    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        boolean isOperator;
        
        for(int i=0 ;i<tokens.length; i++){
            System.out.println(tokens[i]);
            boolean isOperand = isOperand(tokens[i]);
            if(isOperand){
                st.push(tokens[i]);
            }else{
              isOperator  = isOperator(tokens[i]);
              if(isOperator){

                    int top1 = Integer.parseInt(st.pop());
                    int top2 = Integer.parseInt(st.pop());
                    int result = eval(top1, top2, tokens[i]);
                    st.push(Integer.toString(result));
                }
            }
            
        }
        return Integer.parseInt(st.pop());
    }
}
