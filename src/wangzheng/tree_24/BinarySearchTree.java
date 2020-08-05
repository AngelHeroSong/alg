package wangzheng.tree_24;

public class BinarySearchTree {

    private Node tree;

    /**
     * 查询
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        if (tree == null) {
            return null;
        }
        Node p = tree;

        while (p != null) {
            if (data == p.data) {
                return p;
            } else if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(int data) {

        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    Node node = new Node(data);
                    p.right = node;
                    return;
                } else {
                    p = p.right;
                }
            }
            if (data < p.data) {
                if (p.left == null) {
                    Node node = new Node(data);
                    p.left = node;
                    return;
                } else {
                    p = p.left;
                }
            }
        }


    }


    /**
     * 删除
     *
     * @param data
     */
    public void delete(int data) {

        Node p = tree;//要删除的节点
        Node pp = null;//要删除节点的父节点

        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }

        }
        if (p == null) {
            return;
        }

        //要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            //找到该节点右子树中最小的一个
            Node minP = p.right;
            Node minPP = p;

            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;//将minP的数据替换到p中
            p = minP;
            pp = minPP;

        }

        //要删除的节点有1个子节点或者没有子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {//删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }


    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
