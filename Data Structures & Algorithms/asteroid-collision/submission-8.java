import java.util.Stack;

class Solution {
    private boolean willCollide(Stack<Integer> st, int current) {
        if (st.peek() > 0 && current < 0)
            return true;
        return false;
    }

    private int[] stToArr(Stack<Integer> st) {
        return st.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (st.isEmpty()) {
                st.push(asteroids[i]);
            } else {
                boolean collide = willCollide(st, asteroids[i]);
                if (collide) {
                    if (asteroids[i] + st.peek() == 0) {
                        st.pop();
                    } else {
                        // keep fighting the asteroids in stack
                        boolean alive = true;

                        while (!st.isEmpty() && alive && willCollide(st, asteroids[i])) {
                            if (Math.abs(asteroids[i]) > Math.abs(st.peek())) {
                                st.pop();
                            } else if (Math.abs(asteroids[i]) == Math.abs(st.peek())) {
                                // both die -> ???
                                alive = false;
                                st.pop();
                            } else {
                                // current dies -> ???
                                alive = false;
                            }
                        }
                        if(alive){
                            st.push(asteroids[i]);
                        }
                    }
                    
                } else {
                    st.push(asteroids[i]);
                }
            }
        }
        int[] result = stToArr(st);
        return result;
    }
}