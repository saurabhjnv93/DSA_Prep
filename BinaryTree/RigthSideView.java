package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RigthSideView {
    public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            if(root == null)return res;
            queue.offer(root);
            while(!queue.isEmpty()){
                int queueSize = queue.size();
                TreeNode temp = null;
                for(int i=0; i<queueSize;i++){
                    
                    TreeNode flag = queue.poll();
                    temp = flag;
                    if(flag.left != null)queue.offer(flag.left);
                    if(flag.right != null)queue.offer(flag.right);
                }
                res.add(temp.val);
            }
            return res;
        }
}
