package annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        String strFruitProvicer = "信息";
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field:declaredFields){
            if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                strFruitProvicer =  "id:"+annotation.id()+" name:"+annotation.name()+" address:"+annotation.address();
            }
        }
        System.out.println(strFruitProvicer);
    }

    public static void main(String[] args) {

        getFruitInfo(Apple.class);
    }
}
