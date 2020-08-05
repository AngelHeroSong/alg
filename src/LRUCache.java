import java.util.HashMap;

public class LRUCache {


    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int cap) {
        this.map = new HashMap<>(cap);
        this.cache = new DoubleList();
    }

    /**
     * 节点
     */
    private static class Node {
        private int key, val;
        private Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {
        }
    }

    /**
     * 双向链表
     */
    private static class DoubleList {
        private Node head;
        private Node tail;

        public DoubleList() {
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.tail.prev = head;
        }

        private void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        private void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;

        }

        private Node removeLast() {
            Node last = tail.prev;
            last.prev.next = tail;
            tail.prev = last.prev;
            return last;


        }

        private int size() {
            Node node = head.next;
            int size = 0;
            while (node != null && node != tail) {
                node = node.next;
                size++;
            }
            return size;
        }

    }

    public void put(int key, int value) {
        // 先把新节点 x 做出来
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(node);
            // 更新 map 中对应的数据
            map.put(key, node);

        } else {

            if (cache.size() == cap) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(node);
            map.put(key, node);


        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;

    }
}
