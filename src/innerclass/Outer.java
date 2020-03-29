package innerclass;

public class Outer {


    /**
     * 静态内部类
     */
    public static class Inner {
        public void getClassName() {
            System.out.println("Inner");
        }
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.getClassName();

    }
}


class Outer2 {

    private static int a = 10;

    /**
     * 成员内部类
     */
    class Inner2 {
        public void getClassName() {
            System.out.println(a);
        }
    }


}


class Outer3 {

    /**
     * 局部内部类
     */
    public void getClassName() {
        int a = 20;
        class Inner3 {
            public void print(int c) {
                System.out.println(c);
            }
        }
        new Inner3().print(a);
    }

    public static void main(String[] args) {
        Outer3 outer3 = new Outer3();
        outer3.getClassName();
    }

}


/**
 * 匿名内部类
 */
abstract class Worker{
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract int workTime();
}

class TestWork{
   public static void testWorker(Worker worker){
       System.out.println("name:"+worker.getName()+" time:"+worker.workTime());
   }

    public static void main(String[] args) {
        testWorker(new Worker() {
            @Override
            int workTime() {
                return 6;
            }

            @Override
            public String getName() {
                return "alex";
            }
        });
    }
}