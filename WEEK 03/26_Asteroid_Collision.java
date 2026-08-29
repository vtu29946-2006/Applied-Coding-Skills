import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -a) stack.pop();
                else if (top == -a) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) stack.push(a);
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = stack.pop();

        return ans;
    }
}
