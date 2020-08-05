package wangzheng.array_05;

public class Array {
    private int[] data;
    private int n;
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 查询
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index >= count || index < 0) {
            return -1;
        }
        return data[index];
    }

    /**
     * 增加
     *
     * @param index
     * @param value
     */
    public boolean insert(int index, int value) {
        //满了
        if (count == n) {
            return false;
        }
        //index越界
        if (index < 0 || index > count) {
            return false;
        }
        //符合
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        ++count;
        return true;

    }

    /**
     * 删除
     * @param index
     * @return
     */
    public boolean delete(int index) {
        //index越界
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    /**
     * 打印全部
     */
    public void printAll(){
       for (int i = 0;i<count;i++){
           System.out.println(data[i]);
       }
    }

    public static void main(String[] args) {
        Array array = new Array(2);
        array.insert(0,1);
        array.insert(1,2);
        array.printAll();
        array.delete(0);
        array.printAll();




    }

}
