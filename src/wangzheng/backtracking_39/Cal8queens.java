package wangzheng.backtracking_39;

public class Cal8queens {
    int[] result = new int[8];//下标是行，值是列

    public void cal8queens(int row){
        if (row == 8){
            printAll();
            return;
        }

        for (int column = 0;column<8;column++){
            if (isOk(row,column)){
                result[row] = column;
                cal8queens(row+1);
            }
        }

    }


    public boolean isOk(int row,int column){
        int leftUp = column-1,rightUp = column+1;
        for (int i = row-1;i>=0;--i){
            if (result[i] == column){
                return false;
            }
            if (leftUp>=0&&result[i] == leftUp){
                return false;
            }
            if (rightUp<8&&result[i] == rightUp){
                return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    public void printAll(){
        for (int i = 0;i<result.length;i++){
            for (int j = 0;j<8;j++){
                if (result[i] == j){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Cal8queens cal8queens = new Cal8queens();
        cal8queens.cal8queens(0);
    }

}
