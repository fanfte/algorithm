package javabasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by tianen on 2019/2/20
 *
 * @author fanfte
 * @date 2019/2/20
 **/
public class ReflectSample {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> aClass = Class.forName("javabasic.reflect.Robot");
        Robot o = (Robot) aClass.newInstance();
        System.out.println("Class name is " + aClass.getName());
        Method throwHello = aClass.getDeclaredMethod("throwHello", String.class);
        throwHello.setAccessible(true);
        Object str = throwHello.invoke(o, "Fanfte");
        System.out.println("Invoke result is " + str);

        Method m = aClass.getMethod("sayHi", String.class);
        m.invoke(o, "Hello.");

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "fanfte");
        m.invoke(o, "Hello.");

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));
    }
}
