package binary.tree;


import dfs.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        dfs.TreeNode treeNode_3_1 = new dfs.TreeNode(4);
        dfs.TreeNode treeNode_4_1 = new dfs.TreeNode(4);

        dfs.TreeNode root = new dfs.TreeNode(1, treeNode_3_1, treeNode_4_1);

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(root, root));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return false;
        }

        return isSymmetric(root.left, root.right);

    }


    public boolean isSymmetric(TreeNode myNode1, TreeNode myNode2) {
        if(myNode1 == null && myNode2 == null) return true;
        if(myNode1 == null || myNode2 == null) return false;

        return myNode1.val == myNode2.val && isSymmetric(myNode1.left, myNode2.right) && (isSymmetric(myNode1.right, myNode2.left));

        }
    }


