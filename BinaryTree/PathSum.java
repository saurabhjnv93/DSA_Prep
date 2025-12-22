package BinaryTree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null )return false;
        // int[] curr = new int[1];
        return helper(root,targetSum,0);
    }

    private boolean helper(TreeNode root, int tar, int curr){
        if(root == null)return false;
        curr += root.val;

        if(root.left == null && root.right == null){
            return curr == tar;
        }
        boolean lft = helper(root.left,tar,curr);
        boolean rgt = helper(root.right,tar,curr);
        return lft || rgt;
    }
}
