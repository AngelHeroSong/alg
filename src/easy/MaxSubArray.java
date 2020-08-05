package easy;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int sum = 0;
        for (int num:nums){
            if (sum>0){
                sum = sum+num;
            }else {
                sum = num;
            }
            result = Math.max(result,sum);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = new int[]{1,-2,4,-1,6,3};
        System.out.println(maxSubArray.maxSubArray(nums));

    }
}
