package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author srr
 * @date 2020/10/15 15:03
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[][] A = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] ints = test.intervalIntersection(A, B);
        Arrays.stream(ints).forEach(a-> System.out.println(a[0]+","+a[1]));


    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if (A.length == 0 || B.length == 0 ){
            return new int[0][2];
        }

        int i=0,j=0;
        List<int[]> res = new ArrayList<>();

        while (i<A.length && j<B.length){
            int a1=A[i][0],a2=A[i][1];
            int b1=B[j][0],b2=B[j][1];
            if (b1<=a2&&a1<=b2){
                int[] c = new int[2];
                c[0] = Math.max(a1,b1);
                c[1] = Math.min(a2,b2);
                res.add(c);
            }
            if (a2>b2){
                j++;
            }else{
                i++;
            }
        }


        return res.toArray(new int[res.size()][]);
    }
}
