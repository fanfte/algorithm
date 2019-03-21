package jzoffer;

/**
 * Created by tianen on 2019/3/20
 *
 * @author fanfte
 * @date 2019/3/20
 **/
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
