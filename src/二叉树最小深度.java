import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author srr
 * @date 2020/8/5 14:45
 */
public class 二叉树最小深度 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);

            int step = 1;
            while(q!=null && q.size()>0){
                int sz = q.size();
                for(int i = 0;i<sz;i++){
                    TreeNode node = q.poll();
                    if(node.left == null && node.right == null){
                        return step;
                    }
                    if(node.left != null){
                        q.offer(node.left);
                    }
                    if(node.right != null){
                        q.offer(node.right);
                    }

                }

                step++;

            }
            return -1;
        }
    }
}
