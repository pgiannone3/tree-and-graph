/* *
 * * Given the root of a binary tree, return its maximum depth.
 * * A binary tree's maximum depth is the number of nodes along the longest path
 * * from the root node down to the farthest leaf node.
 * */

package dfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MaximumDepthOfBinaryTreeIterative {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<NodeDepth> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int maxDepth = 1;

        stack.add(new NodeDepth(root, 1));

        while (!stack.isEmpty()) {
            var node = stack.pop();
            visited.add(node.node);

            var left = node.node.left;
            var right = node.node.right;

            if(left != null && !visited.contains(left)) stack.push(new NodeDepth(left, node.depth + 1));
            if(right != null && !visited.contains(right)) stack.push(new NodeDepth(right, node.depth + 1));


            if(left != null || right != null) {
                maxDepth = Math.max(maxDepth, node.depth + 1);
            }
        }

        return maxDepth;

    }
}
class NodeDepth {

    TreeNode node;
    int depth;

    public NodeDepth(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
