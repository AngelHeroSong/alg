package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraverse {

    public static void main(String[] args) {
        TreeNode treeNodeRoot = new TreeNode(1);
        TreeNode treeNodeA = new TreeNode(2);
        TreeNode treeNodeB = new TreeNode(3);
        treeNodeRoot.left = treeNodeA;
        treeNodeA.right = treeNodeB;

        PreOrderTraverse preOrderTraverse = new PreOrderTraverse();
        List<Integer> treeNodes = preOrderTraverse.preorderTraversal2(treeNodeRoot);
        for (int i=0;i<treeNodes.size();i++){
            System.out.println(treeNodes.get(i));
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> values = new LinkedList<Integer>();
        preorderTraversal(root, values);
        return values;
    }

    private void preorderTraversal(TreeNode root, List<Integer> values) {
        if (root != null) {
            values.add(root.val);
            preorderTraversal(root.left, values);
            preorderTraversal(root.right, values);
        }
    }

    //非递归
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();

        if (root!=null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);

                if (root.right!=null){
                    stack.push(root.right);
                }

                if (root.left!=null){
                    stack.push(root.left);
                }
            }

        }
        return list;
    }


}

class TreeNode{
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
