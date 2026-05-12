class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> pointStack = new Stack<>();

        int sum = 0;

        for(int i=0; i<operations.length; i++){
            Integer point = tryParse(operations[i]);
            if(point!= null){
                pointStack.push(point);
                sum += point;
            }else{
                switch(operations[i]){
                    case "+":
                        Integer currentPoint = pointStack.pop();
                        Integer prevPoint = pointStack.pop();
                        Integer newPoint = currentPoint + prevPoint;
                        pointStack.push(prevPoint);
                        pointStack.push(currentPoint);
                        pointStack.push(newPoint);
                        sum+=newPoint;
                        break;
                    case "C":
                        currentPoint = pointStack.pop();
                        sum-=currentPoint;
                        break;
                    case "D":
                        currentPoint = pointStack.pop();
                        pointStack.push(currentPoint);
                        pointStack.push(currentPoint*2);
                        sum+=currentPoint*2;
                }
            }
        }
        return sum;
    }

    private static Integer tryParse(String c) {
        try {
            return Integer.parseInt(c);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}