package wangzheng.backtracking_39;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

public class Package01 {
    public int maxW = Integer.MIN_VALUE;

    public void f(int i,int cw,int[] items,int n,int w){

        if (cw == w ||i ==n){
            if (cw>maxW){
                maxW = cw;
            }
            System.out.println(maxW);
            return ;
        }

        f(i+1,cw,items,n,w);
        if (cw+items[i] <= w){
            f(i+1,cw+items[i],items,n,w);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Package01 package01 = new Package01();
        package01.f(0,0,a,10,100);

    }
}
