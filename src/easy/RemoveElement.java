package easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int length = nums.length;
        for (int j =  0;j<length;j++){
            if (nums[j] != val){
                nums[i] = nums[j];
               i++;
            }
        }
        return i;
    }
}
