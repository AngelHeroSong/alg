import java.util.stream.IntStream;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int a = IntStream.range(0, nums.length + 1).sum();
        int b = IntStream.of(nums).sum();
        return  a - b ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,1,2,6};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));

    }
}
