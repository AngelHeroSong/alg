package annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@Test1
public class TestAnnotationClass {

}

class TestAnnotationChild extends TestAnnotationClass{
}

class TestAnnotation{
    public static void main(String[] args) {

        Annotation[] annotations = TestAnnotationChild.class.getAnnotations();
        System.out.println(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(Test1.class)));
    }
}