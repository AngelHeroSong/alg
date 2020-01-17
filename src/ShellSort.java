import java.util.Arrays;

public class ShellSort {
    public void sort(int[] nums){
        int len = nums.length;
        for (int gap = len/2;gap>0;gap =gap/2){
            for (int i = gap;i<len;i++){
                int j = i;
                int temp = nums[j];
                if (nums[j]<nums[j-gap]){
                    while(j-gap>=0&&nums[j-gap]>temp){
                        nums[j] = nums[j-gap];
                        j=j-gap;
                    }
                    nums[j] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] nums = new int[]{1,3,2,6,5,7,100,99,87,89};
        shellSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
