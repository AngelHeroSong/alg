package wangzheng.sorts_12;

public class KthSmallest {


    public static int kthSmallest(int[] a,int n,int k){

        int partition = partition(a,0,n-1);

        while(partition+1!=k){
            if (partition+1<k){
                partition = partition(a,partition+1,n-1);
            }else{
                partition = partition(a,0,partition-1);
            }
        }

        return a[partition];

    }

    public static int partition(int[] a,int p,int r){
        int pviot = a[r];
        int i = p;
        for (int j = p ;j<r;j++){
            if (a[j]<=pviot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        return i;

    }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int[] a = new int[]{9,4,2,56,0,6};
        int i = kthSmallest(a, a.length, 6);
        System.out.println(i);

    }

}
