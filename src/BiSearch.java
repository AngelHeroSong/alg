/**
 * 二分查找
 * 注意
 * 1.结束条件
 * 2.mid的取值
 * 3.start和end 的更新
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        BiSearch biSearch = new BiSearch();
        System.out.println(biSearch.biSearch(a, 0));
    }

    public int biSearch(int[] array, int a) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;//防止溢出
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] < a) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
