package sort;

public class SelectionSort {
    public int[] selectionSort(int[] nums){
        //做第i躺排序
        for (int i = 0,len = nums.length;i<len-1; i++){
            //k是每一趟最小值的位置
            int k = i;
            for (int j = k+1;j<len;j++){
                if (nums[j]<nums[k]){
                    k = j;
                }
            }

            if (i!=k){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = new int[]{1,2,5,7,0,-1,9,100};
        int[] nums2 = selectionSort.selectionSort(nums);
        for (int num : nums2){
            System.out.println(num);
        }
    }
}
