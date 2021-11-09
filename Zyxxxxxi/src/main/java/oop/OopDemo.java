package oop;

/**
 * @author zyx
 */
public class OopDemo extends AbstractDemo implements Interface1, Interface2 {
    /*这里体现了面向对象单继承和多实现的特性*/


    /**
     * 抽象方法的重写
     */
    @Override
    public void method() {
        System.out.println("调用了一个抽象方法");
    }

    @Override
    public void method1() {
        System.out.println("调用了接口方法1");
    }

    @Override
    public void method2() {
        System.out.println("调用了接口方法2");
    }
}
