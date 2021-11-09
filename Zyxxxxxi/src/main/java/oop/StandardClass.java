package oop;

/**
 * @author zyx
 */
public abstract class StandardClass {
    /**
     * 一个类中可以有以下五大成分：
     * 成员变量、成员方法、构造器、代码块、内部类
     * 所有代码脱离了这五大成分都无法通过编译
     *
     * 把一类对象的属性行为封装到一个类中，体现了面向对象的封装性
     */

    /*成员变量*/

    public static String field1 = null;
    private int field2 = 0;


    /*成员方法*/

    public static final void method1() {
        /*code*/
    }

    private final String method2() {
        /*code*/
        return "";
    }

    /**
     * 一个抽象方法
     * 一个有抽象方法的类一定是抽象类，但抽象类中不一定含有抽象方法
     * @return Integer
     */
    public abstract Integer method3();


    /*构造器*/

    /**
     * 无参构造器
     */
    public StandardClass() {
        /*code*/
    }

    /**
     * 带参构造器
     */
    public StandardClass(String temp) {
        /*code*/
    }


    {
        /*代码块*/
        /*code*/
    }


    /*内部类*/

    static class InnerClass {
        /*code*/
    }
}
