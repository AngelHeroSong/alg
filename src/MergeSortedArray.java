public class MergeSortedArray {
    public static void main(String[] args) {

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] a = new int[]{1,2,3,0,0,0,0,0,0};
        int[] b = new int[]{2,3,4,4,7,8};
         mergeSortedArray.merge(a,3,b,b.length);
       for (int i = 0;i<a.length;i++){
           System.out.println(a[i]);
       }
    }
    public void merge(int nums1[],int m,int nums2[],int n){
        int p1 = m-1;
        int p2 = n-1;
        int index = m+n-1;

        while(p1>=0&&p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[index--] = nums1[p1--];
            }else{
                nums1[index--] = nums2[p2--];
            }
        }
        while(p2>=0){
            nums1[index--] = nums2[p2--];
        }
    }

}
