package serializable;

import java.io.*;

public class Worker implements Serializable {

    private static final long serialVersionUID = 12345678L;
    private String name;
    private transient int salary;
    static int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("woker.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        Worker worker = new Worker();
        worker.setName("老大");
        worker.setSalary(66);

        objectOutputStream.writeObject(worker);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("woker.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Worker o = (Worker)objectInputStream.readObject();
        System.out.println(o);

    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

