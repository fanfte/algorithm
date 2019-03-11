package javabasic.reflect;

/**
 * Created by tianen on 2019/2/20
 *
 * @author fanfte
 * @date 2019/2/20
 **/
public class Robot {

    private String name;

    public void sayHi(String helloSentence) {
        System.out.println(helloSentence + name);
    }

    public String throwHello(String tag) {
        return "Hello " + tag;
    }

    static {
        System.out.println("Hello init");
    }
}
