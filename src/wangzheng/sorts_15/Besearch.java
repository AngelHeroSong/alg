package wangzheng.sorts_15;

/**
 * 二分查找
 */
public class Besearch {


    /**
     * 非递归实现
     *
     * @param a
     */
    public static int besearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     *
     * @param a
     */
    public static int besearchp(int[] a, int value, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return besearchp(a, value, mid + 1, high);
        } else {
            return besearchp(a, value, low, mid - 1);
        }

    }

    /**
     * 大于等于给定值的第一个元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int besearchlike(int[] a, int value) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Besearch.besearch(a, 6));
        System.out.println(Besearch.besearchp(a, 6, 0, a.length - 1));
    }
}
