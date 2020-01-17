package DesignPattern.DesignPattern.FactoryMethod;

public abstract class AbstractFactory {
    abstract AbstractProduct createProduct();

    public static void main(String[] args) {
        CodeFactory codeFactory =new CodeFactory();
        codeFactory.createProduct().getProduct();

        ComFactory comFactory = new ComFactory();
        comFactory.createProduct().getProduct();
    }
}
class CodeFactory extends AbstractFactory{
    @Override
    Code createProduct() {
        return new Code();
    }
}
class ComFactory extends AbstractFactory{
    @Override
    Com createProduct() {
        return new Com();
    }
}

abstract class AbstractProduct {
    abstract void getProduct();
}

class Code extends AbstractProduct{

    @Override
    void getProduct() {
        System.out.println("我是code");
    }
}

class Com extends AbstractProduct{

    @Override
    void getProduct() {
        System.out.println("我是com");
    }
}
