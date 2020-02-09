package easy;

import java.util.Arrays;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {



        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);


    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = new int[]{1,2,6,8,0,0,0};
        int[] nums2 = new int[]{4,5};
        merge.merge(nums1,4,nums2,2);
        for (int num :nums1){
            System.out.println(num);
        }


    }
}
