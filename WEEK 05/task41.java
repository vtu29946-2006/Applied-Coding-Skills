import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.pop();
            result.add(current.val);

            // Push left first
            if (current.left != null) {
                stack.push(current.left);
            }

            // Push right second
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        // Reverse the result
        Collections.reverse(result);

        return result;
    }
}