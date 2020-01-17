import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {
       TreeNode treeNodeA = new TreeNode(1);
       TreeNode treeNodeB = new TreeNode(2);
       TreeNode treeNodeC = new TreeNode(3);
       treeNodeA.right = treeNodeB;
       treeNodeB.left = treeNodeC;

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
