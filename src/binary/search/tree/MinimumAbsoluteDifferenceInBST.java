package binary.search.tree;

public class MinimumAbsoluteDifferenceInBST {

    private int minDiff = Integer.MAX_VALUE;
    private Integer prevValue = null;




    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t8 = new TreeNode(8);
        TreeNode t_5 = new TreeNode(-5);

        TreeNode t5 = new TreeNode(5, t3, t8);
        TreeNode root = new TreeNode(2, t_5, t5);


        MinimumAbsoluteDifferenceInBST m = new MinimumAbsoluteDifferenceInBST();
        m.getMinimumDifference(root);
        System.out.println(m.minDiff);
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return min;
        }

        getMinimumDifference(root.left);
        if(prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}

