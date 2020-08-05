package classinit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        //获取Class对象的三种方式
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();

        Class<Person> personClass = Person.class;

        Class<?> class1 = Class.forName("classinit.Person");

        //通过反射获取属性，方法，构造器
        Field[] declaredFields = class1.getDeclaredFields();

        for (Field f : declaredFields) {
            System.out.println(f.toString());
        }

        Method[] declaredMethods = class1.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println(method.toString());
        }

        Constructor<?>[] declaredConstructors = class1.getDeclaredConstructors();

        for (Constructor constructor : declaredConstructors) {
            System.out.println(constructor.toString());
        }


        //创建变量的两种方式
        //1.需要有默认空构造器
        Person o1 = (Person) class1.newInstance();
        //2.获取构造方法并创建对象
        Constructor<?> declaredConstructor = class1.getDeclaredConstructor(String.class, int.class);
        Person o2 = (Person) declaredConstructor.newInstance("xiaoli", 10);

        System.out.println(o1);
        System.out.println(o2);


        //Method invoke
        //1.先获取Class对象
        Class<?> class3 = Class.forName("classinit.Person");
        //2.通过反射api获取Method对象
        Method method = class3.getMethod("setName", String.class);
        //3.获取构造器对象
        Constructor<?> constructor = class3.getConstructor();
        //4.创建对象
        Person o3 = (Person) constructor.newInstance();
        //5.调用invoke方法
        method.invoke(o3, "小明");
        System.out.println(o3.getName());


    }


}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}