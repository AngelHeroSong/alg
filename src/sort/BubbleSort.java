package sort;

public class BubbleSort {
    public int[] bubbleSort(int[] nums){

        for(int i = 0,len = nums.length;i<len-1;i++){
            for (int j = 0;j<len-1-i;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
            return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,3,2,4,1,8};
        BubbleSort bubbleSort = new BubbleSort();
        nums = bubbleSort.bubbleSort(nums);
        for (int num: nums){
            System.out.println(num);
        }
    }
}
