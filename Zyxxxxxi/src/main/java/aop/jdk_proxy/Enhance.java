package aop.jdk_proxy;

/**
 * @author zyx
 */
public class Enhance {
    public void beforeEnhance(){
        System.out.println("before...");
    }

    public void afterEnhance(){
        System.out.println("after...");
    }
}
