public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int cap) {
        this.pq = (Key[]) new Comparable[cap + 1];
    }

    private int parent(int root) {
        return root / 2;
    }

    private int left(int root) {
        return root * 2;
    }

    private int right(int root) {
        return root * 2 + 1;
    }

    /**
     * 插入
     *
     * @param key
     */
    public void insert(Key key) {
        N++;
        pq[N] = key;
        swim(N);

    }

    /**
     * 删除最大元素
     */
    public Key delMax() {
        Key key = pq[1];
        swap(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return key;
    }

    /**
     * 上浮
     *
     * @param k
     */
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(parent(k), k)) {
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            swap(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉
     *
     * @param k
     */
    private void sink(int k) {
        //如果沉到堆底就沉不下去了
        while (left(k) <= N) {
            //先假设左节点更大
            int older = left(k);
            //存在右节点，右节点比左节点大
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            //比子节点都大，不用比较了直接返回
            if (less(older, k)) break;
            swap(k, older);
            k = older;
        }

    }

    /**
     * 比较大小
     *
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;

    }

    /**
     * 交换
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
