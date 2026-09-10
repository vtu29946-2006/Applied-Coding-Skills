import java.util.*;
class Solution {
public int[] maxSlidingWindow(int[] nums, int k) {
Deque<Integer> dq = new ArrayDeque<>();
int n = nums.length;
int[] result = new int[n - k + 1];
int ri = 0;
for (int i = 0; i < n; i++) {
// remove out-of-window indices
if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
dq.pollFirst();
}
// maintain decreasing order
while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
dq.pollLast();
}
dq.offerLast(i);
// record result
if (i >= k - 1) {
result[ri++] = nums[dq.peekFirst()];
}
}
return result;
}
}
