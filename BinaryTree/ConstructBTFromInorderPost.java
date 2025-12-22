package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderPost {
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return treeBuilder(inorder, postorder, inorderIndexMap, 0, inorder.length - 1);
    }

    private TreeNode treeBuilder(int[] inorder, int[] postorder, Map<Integer, Integer> inorderIndexMap, int l, int r) {
        if (l > r) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);

        root.right = treeBuilder(inorder, postorder, inorderIndexMap, inorderIndex + 1, r);
        root.left = treeBuilder(inorder, postorder, inorderIndexMap, l, inorderIndex - 1);

        return root;
    }
}
