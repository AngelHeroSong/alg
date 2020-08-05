package wangzheng.hashtable_20;


import java.util.HashMap;

public class LRUBaseHashTable<K, V> {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * 链表容量
     */
    private int capacity;

    /**
     * 链表长度
     */
    private int length;

    /**
     * 链表头节点
     */
    private DNode<K, V> headNode;

    /**
     * 链表尾节点
     */
    private DNode<K, V> tailNode;

    /**
     * 散列表
     */
    private HashMap<K, DNode<K, V>> table;


    public LRUBaseHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBaseHashTable(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        headNode = new DNode<>();
        tailNode = new DNode<>();
        headNode.next = tailNode;
        tailNode.pre = headNode;
        table = new HashMap<>();
    }

    static class DNode<K, V> {
        private DNode pre;
        private DNode next;
        private K key;
        private V value;

        public DNode() {
        }

        public DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public void add(K key, V value) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            node = new DNode<>(key, value);
            table.put(key,node);
            addNode(node);
            if (++length > capacity) {
                DNode<K, V> removeNode = popHead();
                table.remove(removeNode.key);
                length--;
            }
        } else {
            node.value = value;
            moveNodeToTail(node);
        }

    }

    public void remove(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        length--;
        table.remove(key);

    }

    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveNodeToTail(node);
        return node.value;
    }

    private void moveNodeToTail(DNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 删除节点
     * @param node
     */

    private void removeNode(DNode<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    /**
     * 将新的节点加到尾部
     *
     * @param node
     */

    private void addNode(DNode<K, V> node) {
        node.pre = tailNode.pre;
        node.next = tailNode;
        tailNode.pre.next = node;
        tailNode.pre = node;


    }

    /**
     * 把头节点删除并返回
     * @return
     */
    private DNode<K, V> popHead() {
        DNode popNode = headNode.next;
        removeNode(popNode);
        return popNode;

    }

    public void printAll(){
        DNode node = tailNode.pre;
        while (node.pre!=null){
            System.out.print(node.value+",");
            node = node.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseHashTable<Integer, Integer> lruHashTable = new LRUBaseHashTable<>(5);
        lruHashTable.add(1,1);
        lruHashTable.add(2,2);
        lruHashTable.add(3,3);
        lruHashTable.add(4,4);
        lruHashTable.add(1,99);
        lruHashTable.add(5,5);
        lruHashTable.add(6,6);

        lruHashTable.printAll();



    }
}
