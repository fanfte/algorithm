package jzoffer;

/**
 * Created by tianen on 2019/3/20
 *
 * @author fanfte
 * @date 2019/3/20
 **/
public class Singleton2 {

    private Singleton2() {

    }

    private static class Holder {
        private static Singleton2 singleton2 = new Singleton2();
    }

    private static Singleton2 getInstance() {
        return Holder.singleton2;
    }
}
