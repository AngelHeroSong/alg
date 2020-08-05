package kuaishou;

import wangzheng.array_05.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 合并两个有序二叉树 {
    TreeNode pre = null;

    /**
     * 1.将有序二叉树转成有序双向链表
     * 2.合并两个链表
     * 3.将链表转成二叉树
     */
    public TreeNode mergeKBST(List<TreeNode> treeNodeList) {

        List<TreeNode> nodeList = new ArrayList<>();

        for (int i = 0; i < treeNodeList.size(); i++) {
            final TreeNode node = BSTToList(treeNodeList.get(i));
            nodeList.add(node);
        }
        TreeNode node = mergeList(nodeList);
        TreeNode treeNode = sortedListToBST(node);

        return treeNode;

    }

    //TODO 有问题 下次再看吧
    public TreeNode BSTToList(TreeNode root) {
        //中序遍历是有序的

        if (root.left == null && root.right == null) {//假如只有一个根节点，则返回根节点
            return root;
        }
        //1、将左子树构造成双链表，并返回该链表头结点left
        TreeNode left = BSTToList(root.left);

        //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
        TreeNode p = left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点，
        while (p != null && p.right != null) {
            p = p.right;//最终p为左子树最右边的节点
        }
        //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if (left != null) {//左子树链表不为空
            p.right = root;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
            root.left = p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
        }
        //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right = BSTToList(root.right);

        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if (right != null) {//右子树链表不为空
            right.left = root;//右子树链表的头结点right的左指针指向当前root
            root.right = right;//当前root的右指针指向右子树链表的头结点right
        }
        return left != null ? left : root;//根据左子树链表是否为空返回整个双向链表的头指针。


    }

    /**
     * 合并k个列表
     * 1.用优先级队列
     * 2.两两合并
     *
     * @param
     * @return
     */
    public TreeNode mergeList(List<TreeNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        //创建一个堆，并设置元素的排序方式
        PriorityQueue<TreeNode> queue = new PriorityQueue(new Comparator<TreeNode>() {
            public int compare(TreeNode o1, TreeNode o2) {
                return (o1.value - o2.value);
            }
        });
        //遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (int i = 0; i < lists.size(); i++) {
            TreeNode node = lists.get(i);
            while (node != null) {
                queue.add(node);
                node = lists.get(i).right;
            }
        }
        TreeNode dummy = new TreeNode(-1);
        TreeNode head = dummy;
        //从堆中不断取出元素，并将取出的元素串联起来
        while (!queue.isEmpty()) {
            dummy.right = queue.poll();
            dummy = dummy.right;
        }
        dummy.right = null;
        return head.right;
    }

    private TreeNode findMiddleElement(TreeNode head) {

        // The pointer used to disconnect the left half from the mid node.
        TreeNode prevPtr = null;
        TreeNode slowPtr = head;
        TreeNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.right != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.right;
            fastPtr = fastPtr.right.right;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.right = null;
        }

        return slowPtr;
    }

    public TreeNode sortedListToBST(TreeNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        TreeNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.value);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.right);
        return node;
    }


    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }


    }

    public static void main(String[] args) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);

        treeNodes.add(treeNode);
        treeNodes.add(treeNode);

        合并两个有序二叉树 mergeTree = new 合并两个有序二叉树();
        TreeNode treeNode1 = mergeTree.mergeKBST(treeNodes);

        System.out.println(treeNode1);

    }
}
