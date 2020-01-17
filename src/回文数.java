public class 回文数 {
    public static void main(String[] args) {

        回文数 a = new 回文数();
        System.out.println( a.isPalindrome(1231));
    }
    public boolean isPalindrome(int x) {

        if (x<0){
            return false;

        }

        int reverse = 0 ;
        while(x>reverse){
            reverse = reverse*10+x%10;
            x/=10;
        }
        return x==reverse||x==reverse/10;
    }
}
