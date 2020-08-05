package easy;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[][] array=new int[numRows][numRows];

        for (int i = 0;i<numRows;i++){

            List<Integer> list = new ArrayList<Integer>();

            for (int j = 0;j<=i;j++){
                if (j == 0) {
                    array[i][j]= 1;
                }else if (j == i){
                    array[i][j]= 1;
                }else{
                    array[i][j]=array[i-1][j-1]+array[i-1][j];
                }
                list.add(array[i][j]);
            }

            res.add(list);
        }
        return res;
    }
}
