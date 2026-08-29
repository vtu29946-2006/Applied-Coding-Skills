import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) sb.setCharAt(i, '*');
                else stack.pop();
            }
        }

        while (!stack.isEmpty())
            sb.setCharAt(stack.pop(), '*');

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length(); i++)
            if (sb.charAt(i) != '*') ans.append(sb.charAt(i));

        return ans.toString();
    }
}
