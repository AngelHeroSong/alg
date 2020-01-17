import java.util.Arrays;

public class HeapSort {
    public void sort(int[] nums){

        //建堆
        for(int i = nums.length/2 - 1;i>=0;i--){
            adjustBigHeapNode(nums,i,nums.length-1);
        }
        for (int j = nums.length-1;j>=0;j--){
            //交换
            swap(nums,0,j);
            //建堆
            adjustBigHeapNode(nums,0,j-1);
        }
    }
    public void adjustBigHeapNode(int[] nums,int i,int lastIndex){

        int left = 2*i+1;
        int right = left+1;
        int k = left;
        if (left>lastIndex){
            return;
        }
        if (left<lastIndex){
            if (nums[left]<nums[right]){
                k = right;
            }
        }
        if (nums[k]>nums[i]){
            swap(nums,k,i);
            adjustBigHeapNode(nums,k,lastIndex);
        }

    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = new int[]{6,8,4,7,3,1,2};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
