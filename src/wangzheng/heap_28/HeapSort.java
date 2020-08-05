package wangzheng.heap_28;

public class HeapSort {

    /**
     * 排序
     * @param a
     */
    public void sort(int[] a) {

        buildHeap(a);

        int k = a.length -1;
        while (k>0){
            swap(a,0,k);
            heapify(a,--k,0);
        }
    }

    /**
     * 建堆
     * @param a
     */
    public void buildHeap(int[] a) {
        int len = a.length;
        for (int i = (len - 1) / 2; i >= 0; i++) {
            heapify(a, len - 1, i);
        }

    }

    /**
     * 堆化
     *
     * @param arr
     * @param n   最后堆化下标
     * @param i   要堆化的元素
     */
    public void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[2 * i + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                return;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
