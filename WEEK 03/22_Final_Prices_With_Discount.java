import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int j = stack.pop();
                ans[j] = prices[j] - prices[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
