//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 714 👎 0


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
    HashMap<Integer,Integer> map = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0;i<n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,n-1,0,n-1);
    }

    TreeNode buildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if (preorder_left > preorder_right) {
            return null;
        }
        int rootVal = preorder[preorder_left];
        TreeNode root = new TreeNode(rootVal);
        int rootInorderIndex = map.get(preorder[preorder_left]);
        int leftCount = rootInorderIndex-inorder_left;
        root.left = buildTree(preorder,inorder,preorder_left+1,preorder_left+leftCount,inorder_left,rootInorderIndex-1);
        root.right = buildTree(preorder,inorder,preorder_left+leftCount+1,preorder_right,rootInorderIndex+1,inorder_right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
