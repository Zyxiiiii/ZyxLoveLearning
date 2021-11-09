package aop.jdk_proxy;

/**
 * @author zyx
 */
public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running");
    }
}
