/**
 * Given the root of a binary tree, return the
 * inorder traversal of its nodes' values.
 *
 */
package binary.search.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(root.val);

        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode node, List<Integer> visit) {
        if(node == null) {
            return;
        }

        inorder(node.left, visit);
        visit.add(node.val);

        inorder(node.right, visit);
    }

}
