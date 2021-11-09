package aop.cglib_proxy;

/**
 * @author zyx
 */
public class Enhance {
    public void before(){
        System.out.println("before...");
    }

    public void after(){
        System.out.println("after...");
    }
}
