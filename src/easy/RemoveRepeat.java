package easy;

public class RemoveRepeat {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1, length = nums.length;j<length;j++){
            if (nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }

        }

        return i+1;
    }

    public static void main(String[] args) {
        RemoveRepeat removeRepeat = new RemoveRepeat();
        int [] nums = new int[]{1,1,2,2,3,3};
        System.out.println(removeRepeat.removeDuplicates(nums));
    }
}
