package wangzheng.sorts_11;

/**
 * 冒泡，插入，选择
 */
public class Sorts {

    /**
     * 冒泡排序，a是数组，n表示数组大小
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {//i控制排序的趟数
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {//j控制每一趟排序的次数
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;//表示数据有交换
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {

        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            //找到插入位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

    }
    public static void printAll(int[] a){
        for (int i = 0 ;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {6,4,3,5,1,0};
        Sorts.selectionSort(a,a.length);
        Sorts.printAll(a);
    }
}

