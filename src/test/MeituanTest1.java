package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MeituanTest1 {

    private static class Node {
        private int id;

        private List<Node> children;

        public Node(int id) {
            this.id = id;
            children = new ArrayList<>();
        }


        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", children=" + children +
                    '}';
        }
    }

    private static class PO {
        private int id;
        private int pid;

        public PO(int id, int pid) {
            this.id = id;
            this.pid = pid;
        }


        public int getPid() {
            return pid;
        }


        @Override
        public String toString() {
            return "PO{" +
                    "id=" + id +
                    ", pid=" + pid +
                    '}';
        }
    }

    Node getRootNodeWithChildren(List<PO> poList) {
        //初始化头节点
        Node root = new Node(0);
        if (poList.isEmpty()) {
            return root;
        }

        //根据pid排序
        poList.sort(Comparator.comparing(PO::getPid));

        for (PO po : poList) {

            Node parent = searchParent(root, po);
            if (parent != null) {
                parent.children.add(new Node(po.id));

            }

        }
        return root.children.get(0);

    }

    //查找父节点
    Node searchParent(Node node, PO po) {
        if (node.id == po.pid) {
            return node;
        }
        for (Node node1 : node.children) {
            return searchParent(node1, po);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<PO> pos = new ArrayList<>();
        pos.add(new PO(2, 1));
        pos.add(new PO(1, 0));
        pos.add(new PO(3, 1));
        pos.add(new PO(4, 2));

        MeituanTest1 meituanTest1 = new MeituanTest1();
        Node rootNodeWithChildren = meituanTest1.getRootNodeWithChildren(pos);
        System.out.println(rootNodeWithChildren);
    }

}
