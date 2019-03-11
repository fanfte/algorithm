package javabasic.reflect;

/**
 * Created by tianen on 2019/2/20
 *
 * @author fanfte
 * @date 2019/2/20
 **/
public class ClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\WorkSpace\\algorithm\\", "MyClassLoader");
        Class<?> c = myClassLoader.loadClass("Robot2");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
        System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
