package test;

import java.util.HashSet;
import java.util.Objects;

public class TestHashAndEquals {

    private static class Student{
        private String name;
        private int age;


        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name);
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {

        Student student = new Student("Tom",11);
        Student student1 = new Student("Tom",11);

        HashSet set = new HashSet();
        System.out.println(student);
        set.add(student);
        set.add(student1);
        System.out.println(set.size());

    }
}
