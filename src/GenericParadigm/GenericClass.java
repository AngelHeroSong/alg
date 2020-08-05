package GenericParadigm;

public class GenericClass<T> {
    private T t;
    public  void add(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

    public static void main(String[] args) {

        GenericClass<Integer> integerGenericClass = new GenericClass<>();
        integerGenericClass.add(1);

        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.add("dd");


    }
}
