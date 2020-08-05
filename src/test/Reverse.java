package test;

public class Reverse {


    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-1233));
    }

    public int reverse(int number) {
        int result = 0;
        while (number != 0) {
            int pop = number % 10;
            number = number / 10;
            result = result * 10 + pop;
        }
        return result;
    }
}
