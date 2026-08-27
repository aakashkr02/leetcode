class Solution {

    int max = 0;

    public int longestZigZag(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root.left, false, 1);
        dfs(root.right, true, 1);

        return max;
    }

    private void dfs(TreeNode node, boolean goLeft, int length) {

        if (node == null) {
            return;
        }

        max = Math.max(max, length);

        if (goLeft) {
            // Next move should be left
            dfs(node.left, false, length + 1);

            // Restart from right
            dfs(node.right, true, 1);

        } else {
            // Next move should be right
            dfs(node.right, true, length + 1);

            // Restart from left
            dfs(node.left, false, 1);
        }
    }
}