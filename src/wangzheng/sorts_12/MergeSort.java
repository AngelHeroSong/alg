package wangzheng.sorts_12;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] a= new int[]{1,9,3,5,3,9,4,6,8,0};
        MergeSort.mergeSort(a,a.length);
        printAll(a);
    }

    public static void mergeSort(int[] a, int n) {

        mergeSortP(a, 0, n-1);
    }

    public static void mergeSortP(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergeSortP(a, p, q);
        mergeSortP(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void merge(int[] a, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int k = 0;

        int[] temp = new int[r - p + 1];//临时数组

        while (i <= q && j <= r) {
            if (a[i] <=a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        //将剩余的填充到临时数组里
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = a[start++];
        }

        //将临时数组的元素赋值给原数组
        for (int z = 0; z <= r - p; z++) {
            a[p + z] = temp[z];
        }


    }

    public static void printAll(int[] a){
        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
