//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder,postorder,0,n-1,0,n-1);

    }

   TreeNode build(int[] inorder,int[] postorder,int inorder_left,int inorder_right,int postorder_left,int postorder_right){
        if (inorder_left>inorder_right){
            return null;
        }
        int root = postorder[postorder_right];

        int inorder_root_index = 0 ;

        for (int i = inorder_left;i<=inorder_right;i++){
            if (inorder[i] == root){
                inorder_root_index = i;
            }
        }
        int leftSize = inorder_root_index-inorder_left;
        TreeNode rootNode = new TreeNode(root);
       rootNode.left = build(inorder,postorder,inorder_left,inorder_root_index-1,postorder_left,postorder_left+leftSize-1);
       rootNode.right = build(inorder,postorder,inorder_root_index+1,inorder_right,postorder_left+leftSize,postorder_right-1);

        return rootNode;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
