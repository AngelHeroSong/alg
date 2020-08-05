package wangzheng.stack_08;

/**
 * 用数组实现一个栈
 */
public class ArrayStack {
    private String[] data;
    private int n;
    private int count;

    public ArrayStack(int n) {
        this.data = new String[n];
        this.n = n;
        count = 0;
    }

    public boolean push(String value) {
        if (count == n) {
            return false;
        }
        data[count] = value;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String ret = data[count - 1];
        count--;
        return ret;

    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.printAll();
        arrayStack.pop();
        arrayStack.printAll();


    }
}
