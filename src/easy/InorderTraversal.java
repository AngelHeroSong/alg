package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNodeRoot = new TreeNode(1);
        TreeNode treeNodeA = new TreeNode(2);
        TreeNode treeNodeB = new TreeNode(3);
        treeNodeRoot.left = treeNodeA;
        treeNodeA.right = treeNodeB;

        InorderTraversal inorderTraversal = new InorderTraversal();
       List<Integer> list = inorderTraversal.inorderTraversal(treeNodeRoot);
       for (int i =0;i<list.size();i++){
           System.out.println(list.get(i));
       }

    }
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        if (root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode cur = root;
            while(!stack.isEmpty()||cur!=null){
             if (cur!=null){
                stack.push(cur);
                cur = cur.left;
             }else{
                 cur = stack.pop();
                 list.add(cur.val);
                 cur = cur.right;
             }
            }
        }
        return list;
    }
}
