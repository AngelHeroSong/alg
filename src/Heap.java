public class Heap {
    private int[] a;// 数组，从下标 1 开始存储数据
    private int n;// 堆可以存储的最大数据个数
    private int count;// 堆中已经存储的数据个数

    public Heap(int n) {
        a = new int[n + 1];
        this.n = n;
        count = 0;
    }

    /**
     * 堆增加数据
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i / 2] < a[i]) {
            swap(a, i, i / 2);
            i = i / 2;
        }

    }

    /**
     * 删除堆顶元素
     */
    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    /**
     * 堆化过程
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {

        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i * 2] > a[i]) maxPos = 2 * i;
            if (i * 2 + 1 <= n && a[i * 2 + 1] > a[maxPos]) maxPos = 2 * i + 1;
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 排序
     * @param a
     * @param n
     */
    public void sort(int[] a,int n){

        buildHeap(a,n);
        int k =n;
        while(k>1){
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }

    }

    /**
     * 交换数组中两个位置的值
     * @param a
     * @param s1
     * @param s2
     */
    public void swap(int[] a, int s1, int s2) {
        int temp = a[s1];
        a[s1] = a[s2];
        a[s2] = temp;

    }

    public static void main(String[] args) {
        //第一种建堆的方法
        Heap heap = new Heap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(6);
        heap.insert(5);
        heap.insert(5);
        System.out.println("第一种建堆方法");
        for (int i = 0; i < heap.a.length; i++) {
            System.out.println(heap.a[i]);
        }
        //删除堆顶元素
        heap.removeMax();
        System.out.println("删除堆顶元素后");
        for (int i = 0; i < heap.a.length; i++) {
            System.out.println(heap.a[i]);
        }

        //第二钟建堆的方法
        Heap heap1 = new Heap(5);
        int[] init = new int[]{0,1, 3, 2, 5, 4};
        heap1.buildHeap(init,5 );
        System.out.println("第二种建堆方法");
        for (int i = 0; i < init.length; i++) {
            System.out.println(init[i]);
        }

        //排序
        heap1.sort(init,5);
        System.out.println("排序");
        for (int i = 0; i < init.length; i++) {
            System.out.println(init[i]);
        }

    }


}
