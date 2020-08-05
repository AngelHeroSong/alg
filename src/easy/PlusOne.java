package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
       int length =  digits.length;
        for (int j = length -1;j>=0;j--){
            if (digits[j]+1 == 10){
                digits[j] = 0;
            }else{
                digits[j] = digits[j] + 1;
                break;
            }
        }

        if (digits[0]==0){
            int[] array = new int[length+1];
            array[0] = 1;
            System.arraycopy(digits,0,array,1,length);
            return array;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = new int[]{9,9,9,8};
        int[] res = plusOne.plusOne(digits);
        for (int re : res){
            System.out.println(re);
        }

    }
}
