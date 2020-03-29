package classinit;

public class NotInit {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Child.val);  
        Father[] father = new Father[4];
        System.out.println(Constant.HELLO);
        Class<Child> childClass = Child.class;
        Class<?> child = Class.forName("classinit.Child");


    }  
  
}  
  
  
class Father {  
    static {  
        System.out.println("Father init!");  
    }  
      
    public static int val = 100;  
}
  
class Child extends Father {  
    static {  
        System.out.println("Child init!");  
    }  
}  
  
class Constant {  
    static {  
        System.out.println("Constant init");  
    }  
      
    public static final String HELLO = "HELLO";  
}  
