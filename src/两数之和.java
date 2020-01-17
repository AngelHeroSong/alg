import java.util.HashMap;

public class 两数之和 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int current;

        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                return new int[]{map.get(otherNum) ,i};
            }
            map.put(nums[i],i);

        }
        throw new IllegalArgumentException("no");
    }
}
