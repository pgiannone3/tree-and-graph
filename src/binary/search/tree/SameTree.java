/***
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are
 * structurally identical, and the nodes have the same value.
 */

package binary.search.tree;

public class SameTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        TreeNode head = new TreeNode(2, t, null);

        TreeNode t1 = new TreeNode(2);
        TreeNode head1 = new TreeNode(2, null, t1);

        SameTree s = new SameTree();
        System.out.println(s.inorder(head, head1));
    }



    private boolean inorder(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }

        if(p == null || q == null || p.val != q.val){
            return false;
        }

        boolean u = inorder(p.left, q.left);
        boolean u1 = inorder(p.right, q.right);

        return u && u1;
    }
}
