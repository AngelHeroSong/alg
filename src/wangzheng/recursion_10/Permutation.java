package wangzheng.recursion_10;

public class Permutation {

    public void swap (int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void print(int[] array){
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public void permutation(int[] array,int length,int start){
        if (start ==length){
            print(array);
            return;
        }else {
            for (int i = start;i<length;i++){
                swap(array,start,i);
                permutation(array,length,start+1);
                swap(array,length,i);
            }
        }


    }
}
