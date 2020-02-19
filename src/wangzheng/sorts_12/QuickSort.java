package wangzheng.sorts_12;

public class QuickSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,9,8,5,0,2,9,7};
        QuickSort.quickSort(a,a.length);
        printAll(a);
    }

    public static void quickSort(int[] a,int n){

        quickSortp(a,0,n-1);
    }
    public static void quickSortp(int[] a,int p ,int r){

        if (p>=r){
            return;
        }
        int q = partition(a,p,r);
        quickSortp(a,p,q-1);
        quickSortp(a,q+1,r);
    }
    public static int partition(int[] a,int p,int r){

        int pivot = a[r];

        int i = p;

        for (int j = p;j<r;++j){
            if (a[j]<pivot){
                if (i==j){
                    ++i;
                }else {
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j]= temp;
                }
            }
        }

        int temp = a[i];
        a[i]=a[r];
        a[r] = temp;
        return i;

    }
    public static void printAll(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
