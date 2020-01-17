public class InsertSort {
    public int[] insertSort(int[] nums){
        for (int i = 1,len = nums.length;i<nums.length;i++){
            int insertNode = nums[i] ;
            int j = i-1;
            while (j>=0&&insertNode<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = insertNode;
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] nums = new int[]{1,3,5,8,4,0};
        insertSort.insertSort(nums);
        for (int num:nums){
            System.out.println(num);
        }
    }
}
