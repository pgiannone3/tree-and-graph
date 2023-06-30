/***
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are
 * structurally identical, and the nodes have the same value.
 */

package binary.tree;
public class SameTree {

    public static void main(String[] args) {

        TreeNode t_15 = new TreeNode(15);
        TreeNode t_5 = new TreeNode(5);
        TreeNode t_10 = new TreeNode(10, t_5, t_15);

        TreeNode t_15_1 = new TreeNode(15);
        TreeNode t_5_1 = new TreeNode(5, null, t_15_1);
        TreeNode t_10_1 = new TreeNode(10, t_5_1, null);

        SameTree s = new SameTree();
        System.out.println(s.check(t_10, t_10_1));
    }



    private boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val) {
            return false;
        }

        return check(p.left, q.left) && check(p.right, q.right);
    }
}
