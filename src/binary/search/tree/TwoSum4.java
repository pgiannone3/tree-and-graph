package binary.search.tree;

import java.util.HashSet;

public class TwoSum4 {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(2, n1, n3);

        TwoSum4 twoSum4 = new TwoSum4();
        System.out.println(twoSum4.findTarget(root, 3));

    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> mySet = new HashSet<>();
        return visit(root, mySet, k);
    }

    private boolean visit(TreeNode node, HashSet<Integer> visited, int target) {
        if(node == null) {
            return false;
        }

        var bool1 = visit(node.left, visited, target);

        var maybeVal = target - node.val;
        if(visited.contains(maybeVal)) {
            return true;
        }
        visited.add(node.val);
        var bool2 = visit(node.right, visited, target);

        return bool1 || bool2;
    }
}
