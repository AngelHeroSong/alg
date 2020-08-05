public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        删除排序数组中的重复项 a = new 删除排序数组中的重复项();
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println(a.removeDuplicates(nums));
        for (int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
       }
       int i = 0;
        for (int j = 0;j<nums.length;j++){
            if (nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
