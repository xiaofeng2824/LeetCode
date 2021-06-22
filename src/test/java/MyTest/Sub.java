package MyTest;

/**
 * @author caoxiaofeng
 * @date 2020-06-13 13:22
 */

class Base{

    private String beanName = "base";

    public Base(){
        callName();
    }

    public void callName(){
        System.out.println(beanName);
    }
}
public class Sub extends  Base{

    private String baseName = "sub";

    public void callName(){
        System.out.println(baseName);
    }
//    public Sub(){
//        System.out.println("sub");
//    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}
