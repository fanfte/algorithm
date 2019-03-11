package javabasic.reflect;

/**
 * Created by tianen on 2019/2/20
 *
 * @author fanfte
 * @date 2019/2/20
 **/
public class LoadDifference {

    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader classLoader = Robot.class.getClassLoader();
        Class<?> aClass = Class.forName("javabasic.reflect.Robot");
    }
}
